import org.telegram.telegrambots.bots.TelegramWebhookBot;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.meta.exceptions.TelegramApiRequestException;
import org.telegram.telegrambots.meta.generics.BotSession;
import org.telegram.telegrambots.meta.generics.LongPollingBot;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main extends TelegramWebhookBot implements LongPollingBot {
    Set<Long> humans = new HashSet<>();

    public static void main(String[] args) throws TelegramApiException {
        TelegramBotsApi telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);
        BotSession botSession = telegramBotsApi.registerBot(new Main());
        botSession.start();
    }

    @Override
    public void onUpdateReceived(Update update) {
        primeryMenyu(update);
    }

    @Override
    public void clearWebhook() throws TelegramApiRequestException {

    }

    public void primeryMenyu(Update update) {
        Message message = update.getMessage();
        String text = message.getText();
        Long chatId = message.getChatId();
        SendMessage sendMessage = new SendMessage();
        switch (text) {
            case "/start":
                sendMessage.setChatId(chatId);
                sendMessage.setText("Salom bizning botimizga hush kelibsiz\\nBu bot ItTechnopark haqida ma'lumot beradi");
                humans.add(chatId);
                buttonYasash(sendMessage);
                break;
            case "Ma'lumotlar✔":
//                getUserRequest(chatId, "Ma'lumotlar", false);
                break;
            case "Kurslarimiz👉":
                sendMessage.setChatId(chatId);
                sendMessage.setText("IT TECHNOPARKning kurslari haqida ma'lumot ");
                buttonYasashKurslar(sendMessage);
//                Kurslarimiz(update);
                break;
            case "Aloqa o'rnatish":
//                getUserRequest(chatId, "Aloqa o'rnatish", false);
                break;
            case "Statistika📝":
                sendMessage.setChatId(chatId);
                buttonYasash(sendMessage);
                int tr = 1;
                for (Long human : humans) {
                    sendMessage.setText(String.valueOf(tr) + "ta odam bu totdan foydalanyapti⚜️🖤");
                    System.out.println(human);
                    tr++;
                }
                break;
            case "Foundation":
                sendMessage.setChatId(chatId);
                sendMessage.setText("Foundation");
                break;
            case "Backend":
                sendMessage.setChatId(chatId);
                sendMessage.setText("Backend");
                break;
            case "Frontend":
                sendMessage.setChatId(chatId);
                sendMessage.setText("Frontend");
                break;
            case "Android":
                sendMessage.setChatId(chatId);
                sendMessage.setText("Android");
                break;
            case "Grafik Dizayn":
                sendMessage.setChatId(chatId);
                sendMessage.setText("Grafik Dizayn");
                break;
            case "3ds Max":
                sendMessage.setChatId(chatId);
                sendMessage.setText("3ds Max");
                break;
            case "Roboto texnika":
                sendMessage.setChatId(chatId);
                sendMessage.setText("Roboto texnika");
                break;
            case "Kompyuter Savothonligi":
                sendMessage.setChatId(chatId);
                sendMessage.setText("Kompyuter Savothonligi");
                break;
            case "SMM":
                sendMessage.setChatId(chatId);
                sendMessage.setText("SMM");
                break;
            case "Web dizayn":
                sendMessage.setChatId(chatId);
                sendMessage.setText("Web dizayn");
                break;
            case "Orqaga↩":
                sendMessage.setChatId(chatId);
                sendMessage.setText("orqaga↩");
                buttonYasash(sendMessage);
                break;
            default:
                sendMessage.setChatId(chatId);
                sendMessage.setText("Bizda bunaqa bo'lim yo'q");
                break;
        }
        try {
            execute(sendMessage);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }


    public static void buttonYasash(SendMessage sendMessage) {
        ReplyKeyboardMarkup keyboardMarkup = new ReplyKeyboardMarkup();
        List<KeyboardRow> keyboard = new ArrayList<>();
        KeyboardRow row = new KeyboardRow();
        row.add("Ma'lumotlar✔");
        row.add("Kurslarimiz👉");
        KeyboardRow row1 = new KeyboardRow();
        row1.add("Statistika📝");
        row1.add("Aloqa o'rnatish");
        keyboard.add(row);
        keyboard.add(row1);
        keyboardMarkup.setKeyboard(keyboard);
        keyboardMarkup.setResizeKeyboard(true);
        sendMessage.setReplyMarkup(keyboardMarkup);
    }

    public static void buttonYasashKurslar(SendMessage sendMessage) {
        ReplyKeyboardMarkup keyboardMarkup = new ReplyKeyboardMarkup();
        List<KeyboardRow> keyboard = new ArrayList<>();
        KeyboardRow row = new KeyboardRow();
        row.add("Foundation");
        row.add("Backend");
        KeyboardRow row1 = new KeyboardRow();
        row1.add("Frontend");
        row1.add("Android");
        KeyboardRow row2 = new KeyboardRow();
        row2.add("Grafik Dizayn");
        row2.add("3ds Max");
        KeyboardRow row3 = new KeyboardRow();
        row3.add("SMM");
        row3.add("Web dizayn");
        KeyboardRow row4 = new KeyboardRow();
        row4.add("Roboto texnika");
        row4.add("Kompyuter Savothonligi");
        KeyboardRow row5 = new KeyboardRow();
        row5.add("Orqaga↩");
        keyboard.add(row);
        keyboard.add(row1);
        keyboard.add(row2);
        keyboard.add(row3);
        keyboard.add(row4);
        keyboard.add(row5);
        keyboardMarkup.setKeyboard(keyboard);
//        keyboardMarkup.setResizeKeyboard(true).setSelective(true);
        sendMessage.setReplyMarkup(keyboardMarkup);
    }

//    public static void getUserRequest(Long chatId, String cource, Boolean chek) {
//        buttonText.put(chatId, cource);
//        buttonChat.put(chatId, chek);
//    }

    @Override
    public BotApiMethod onWebhookUpdateReceived(Update update) {
        return null;
    }

    @Override
    public String getBotUsername() {
        return "testbekMy_bot";
    }

    @Override
    public String getBotToken() {
        return "5645357698:AAGmunKiq08R-Arq18yWX6Bx3Ow8udoZdjs";
    }

    @Override
    public String getBotPath() {
        return null;
    }
}
