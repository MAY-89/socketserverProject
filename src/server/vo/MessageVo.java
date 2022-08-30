package server.vo;

import java.io.File;

import constant.BizConstant;
import server.vo.user.UserVo;

public class MessageVo {
    
    private BizConstant Message;
    private UserVo userVo;
    
    private String chat;
    private File file;

    public BizConstant getMessage() {
        return this.Message;
    }

    public void setMessage(BizConstant Message) {
        this.Message = Message;
    }

    public UserVo getUserVo() {
        return this.userVo;
    }

    public void setUserVo(UserVo userVo) {
        this.userVo = userVo;
    }

    public String getChat() {
        return this.chat;
    }

    public void setChat(String chat) {
        this.chat = chat;
    }

    public File getFile() {
        return this.file;
    }

    public void setFile(File file) {
        this.file = file;
    }

}
