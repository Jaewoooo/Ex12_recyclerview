
package kr.co.dothome.jkl421.ex12_recyclerview.Member;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MemberData {

    @SerializedName("code")
    @Expose
    private String code;
    @SerializedName("members")
    @Expose
    private List<Member> members = null;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public List<Member> getMembers() {
        return members;
    }

    public void setMembers(List<Member> members) {
        this.members = members;
    }

}
