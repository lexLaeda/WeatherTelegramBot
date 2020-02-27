import bean.Request;

import exception.comandexception.NotACommandException;
import myenum.Command;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Chat;

import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.logging.Logger;

public abstract class MyBot extends TelegramLongPollingBot {
    protected void sendReply(Chat chat, String message){
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chat.getId());
        sendMessage.setText(message);
        try {
            execute(sendMessage);
        } catch (TelegramApiException e) {
            Logger.getAnonymousLogger();
        }
    }
    protected Request getRequest(String userRequest)throws NotACommandException {
        String[] words = userRequest.trim().split("\\s+");
        if (userRequest.startsWith("/") && words.length >= 2){
            Command command = Command.valueOf(words[0].substring(1).toUpperCase());
            String[] args = new String[words.length-1];
            for(int i = 1, j =0; i < words.length; i++, j++){
                args[j] = words[i];
            }
            StringBuilder sb = new StringBuilder();
            for(String arg : args){
                sb.append(arg);
                sb.append(" ");
            }
            return new Request(command,sb.toString().trim());
        } else if(userRequest.startsWith("/")){
            Command command = Command.valueOf(words[0].substring(1).toUpperCase());
            String emptyArgs = "";
            return new Request(command,emptyArgs);
        } else{
            throw new NotACommandException(userRequest);
        }
    }


}
