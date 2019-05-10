package jp.ac.titech.itpro.sdl.chat.message;

import android.os.Parcel;
import android.os.Parcelable;

public class ChatMessage implements Parcelable {
    final static String FIELD_SEQ = "seq";
    final static String FIELD_TIME = "time";
    final static String FIELD_CONTENT = "content";
    final static String FIELD_SENDER = "sender";
    final static String FIELD_SOUND = "sound";

    public final int seq;
    public final long time;
    public final String content;
    public final String sender;
    public int beep_sound = 0;

    private ChatMessage(int seq, long time, String content, String sender) {
        this.seq = seq;
        this.time = time;
        this.content = content;
        this.sender = sender;
    }

    public ChatMessage(int seq, long time, String content, String sender, int beep_sound){
        this(seq, time, content, sender);
        this.beep_sound = beep_sound;
    }

    private ChatMessage(Parcel in) {
        seq = in.readInt();
        time = in.readLong();
        content = in.readString();
        sender = in.readString();
        beep_sound = in.readInt();
    }

    @SuppressWarnings("NullableProblems")
    @Override
    public String toString() {
        return content;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(seq);
        dest.writeLong(time);
        dest.writeString(content);
        dest.writeString(sender);
    }

    public static final Creator<ChatMessage> CREATOR = new Creator<ChatMessage>() {
        @Override
        public ChatMessage createFromParcel(Parcel src) {
            return new ChatMessage(src);
        }

        @Override
        public ChatMessage[] newArray(int size) {
            return new ChatMessage[size];
        }
    };
}
