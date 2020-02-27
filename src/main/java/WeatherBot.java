import bean.Request;
import jason.WeatherCal;
import myenum.Command;
import org.telegram.telegrambots.meta.api.objects.Chat;
import org.telegram.telegrambots.meta.api.objects.Location;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import personal.BotNameToken;

import java.util.Locale;

public class WeatherBot extends MyBot implements BotNameToken {
    private WeatherCal weatherCal = new WeatherCal();

    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {
            Message inMessage = update.getMessage();
            sendReply(inMessage, getRequest(inMessage.getText()));
        }

    }

    private void sendReply(Message inMessage, Request userRequest) {
        sendReply(inMessage, userRequest.getCommand(), userRequest.getArgs());
    }

    private void sendReply(Message inMessage, Command command, String text) {
        switch (command) {
            case LIST:
                sendReply(inMessage.getChat(), commandList());
                break;
            case WEATHER:
                sendReply(inMessage, text);
                break;
        }
    }

    private void sendReply(Message inMessage, String text) {
        if (!text.equals("")) {
            sendReply(inMessage.getChat(), getDailyWeather(text));
        }
    }

    private String getDailyWeather(String text) {
        return weatherCal.getDaylyWeather(text);
    }

    private String commandList() {
        StringBuilder sb = new StringBuilder();
        for (Command command : Command.values()) {
            sb.append("/");
            sb.append(getCommandDescription(command));
            sb.append("\n");
        }
        return sb.toString();
    }

    private String getCommandDescription(Command command) {
        String commandName = command.toString().toLowerCase();
        switch (command) {
            case LIST:
                return String.format(Locale.ENGLISH,
                        "%s выведет спиоок доступных команд с их описание.", commandName);
            case WEATHER:
                return String.format(Locale.ENGLISH, "%s \"название города\" выведет " +
                        "основные парметры погоды для этого города. " +
                        "Если у Вас включена геолокация, название города можно не указывать.", commandName);
        }
        throw new UnsupportedOperationException();
    }

    @Override
    public String getBotUsername() {
        return BOTNAME;
    }

    @Override
    public String getBotToken() {
        return TOKEN;
    }


}


