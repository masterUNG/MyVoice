package nsmahidol.tan.chanita.myvoice.ultility;

/**
 * Created by masterung on 30/9/2017 AD.
 */

public class MyConstant {
//    ต้องการ
    private String[] requestStrings = new String[]{
            "อาหารและน้ำ",
            "การขับถ่าย",
            "การเปลี่ยนที่นอน",
            "การหายใจ",
            "ความสะอาด",
            "ความผ่อนคลาย"
    };
//รู้สึก
    private String[] feelingStrings = new String[]{
            "ร่างกาย",
            "จิตใจ"
    };

//    คำถาม
    private String[] questionStrings = new String[]{
            "พ่อแม่",
            "ร่างกาย หรือ อาการ",
            "เวลา"
    };

    //    เร่งด่วน
    private String[] emergencyStrings = new String[]{
            "คลื่นไส้อาเจียน",
            "หายใจไม่ออก",
            "เจ็บปวดมาก"};

    public String[] getEmergencyStrings() {
        return emergencyStrings;
    }

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
