package nsmahidol.tan.chanita.myvoice.ultility;

/**
 * Created by masterung on 30/9/2017 AD.
 */

public class MyConstant {

    private String[] requestStrings = new String[]{
            "อาหารและน้ำ",
            "การขับถ่าย",
            "การเปลี่ยนที่นอน",
            "การหายใจ",
            "ความสะอาด",
            "ความผ่อนคลาย"
    };

    private String[] feelingStrings = new String[]{
            "ร่างกาย",
            "จิตใจ"
    };

    private String[] questionStrings = new String[]{
            "พ่อแม่",
            "ร่างกาย หรือ อาการ",
            "เวลา"
    };

    public String[] getFeelingStrings() {
        return feelingStrings;
    }

    public String[] getQuestionStrings() {
        return questionStrings;
    }

    public String[] getRequestStrings() {
        return requestStrings;
    }
}
