package com.zue.be.component;

import java.util.Arrays;
import java.util.regex.Pattern;

public class Utils {

    /**
     * Lop tien ich xu ly ky tu tieng Viet
     *
     * @author quyetdv
     *
     * @implNote I borrow from this https://quyetdo289.wordpress.com/2015/05/17/loai-bo-dau-tieng-viet-trong-java/
     */
    public static class VNCharacterUtils {
        // Mang cac ky tu goc co dau
        private static final char[] SOURCE_CHARACTERS = { 'À', 'Á', 'Â', 'Ã', 'È', 'É',
                'Ê', 'Ì', 'Í', 'Ò', 'Ó', 'Ô', 'Õ', 'Ù', 'Ú', 'Ý', 'à', 'á', 'â',
                'ã', 'è', 'é', 'ê', 'ì', 'í', 'ò', 'ó', 'ô', 'õ', 'ù', 'ú', 'ý',
                'Ă', 'ă', 'Đ', 'đ', 'Ĩ', 'ĩ', 'Ũ', 'ũ', 'Ơ', 'ơ', 'Ư', 'ư', 'Ạ',
                'ạ', 'Ả', 'ả', 'Ấ', 'ấ', 'Ầ', 'ầ', 'Ẩ', 'ẩ', 'Ẫ', 'ẫ', 'Ậ', 'ậ',
                'Ắ', 'ắ', 'Ằ', 'ằ', 'Ẳ', 'ẳ', 'Ẵ', 'ẵ', 'Ặ', 'ặ', 'Ẹ', 'ẹ', 'Ẻ',
                'ẻ', 'Ẽ', 'ẽ', 'Ế', 'ế', 'Ề', 'ề', 'Ể', 'ể', 'Ễ', 'ễ', 'Ệ', 'ệ',
                'Ỉ', 'ỉ', 'Ị', 'ị', 'Ọ', 'ọ', 'Ỏ', 'ỏ', 'Ố', 'ố', 'Ồ', 'ồ', 'Ổ',
                'ổ', 'Ỗ', 'ỗ', 'Ộ', 'ộ', 'Ớ', 'ớ', 'Ờ', 'ờ', 'Ở', 'ở', 'Ỡ', 'ỡ',
                'Ợ', 'ợ', 'Ụ', 'ụ', 'Ủ', 'ủ', 'Ứ', 'ứ', 'Ừ', 'ừ', 'Ử', 'ử', 'Ữ',
                'ữ', 'Ự', 'ự', };

        // Mang cac ky tu thay the khong dau
        private static final char[] DESTINATION_CHARACTERS = { 'A', 'A', 'A', 'A', 'E',
                'E', 'E', 'I', 'I', 'O', 'O', 'O', 'O', 'U', 'U', 'Y', 'a', 'a',
                'a', 'a', 'e', 'e', 'e', 'i', 'i', 'o', 'o', 'o', 'o', 'u', 'u',
                'y', 'A', 'a', 'D', 'd', 'I', 'i', 'U', 'u', 'O', 'o', 'U', 'u',
                'A', 'a', 'A', 'a', 'A', 'a', 'A', 'a', 'A', 'a', 'A', 'a', 'A',
                'a', 'A', 'a', 'A', 'a', 'A', 'a', 'A', 'a', 'A', 'a', 'E', 'e',
                'E', 'e', 'E', 'e', 'E', 'e', 'E', 'e', 'E', 'e', 'E', 'e', 'E',
                'e', 'I', 'i', 'I', 'i', 'O', 'o', 'O', 'o', 'O', 'o', 'O', 'o',
                'O', 'o', 'O', 'o', 'O', 'o', 'O', 'o', 'O', 'o', 'O', 'o', 'O',
                'o', 'O', 'o', 'U', 'u', 'U', 'u', 'U', 'u', 'U', 'u', 'U', 'u',
                'U', 'u', 'U', 'u', };

        /**
         * Bo dau 1 ky tu
         *
         * @param ch
         * @return
         */
        public static char removeAccent(char ch) {
            int index = Arrays.binarySearch(SOURCE_CHARACTERS, ch);
            if (index >= 0) {
                ch = DESTINATION_CHARACTERS[index];
            }
            return ch;
        }

        /**
         * Bo dau 1 chuoi
         *
         * @param s
         * @return
         */
        public static String removeAccent(String s) {
            StringBuilder sb = new StringBuilder(s);
            for (int i = 0; i < sb.length(); i++) {
                sb.setCharAt(i, removeAccent(sb.charAt(i)));
            }
            return sb.toString();
        }
    }

    public static boolean validateName(String name) {
        String nameRegEx = "^[A-ZÀÁẠẢÃÂẦẤẬẨẪĂẰẮẶẲẴÈÉẸẺẼÊỀẾỆỂỄÌÍỊỈĨÒÓỌỎÕÔỒỐỘỔỖƠỜỚỢỞỠÙÚỤỦŨƯỪỨỰỬỮỲÝỴỶỸĐ][a-zàáạảãâầấậẩẫăằắặẳẵèéẹẻẽêềếệểễìíịỉĩòóọỏõôồốộổỗơờớợởỡùúụủũưừứựửữỳýỵỷỹđ]{1,6}(?:[ ][A-ZÀÁẠẢÃÂẦẤẬẨẪĂẰẮẶẲẴÈÉẸẺẼÊỀẾỆỂỄÌÍỊỈĨÒÓỌỎÕÔỒỐỘỔỖƠỜỚỢỞỠÙÚỤỦŨƯỪỨỰỬỮỲÝỴỶỸĐ][a-zàáạảãâầấậẩẫăằắặẳẵèéẹẻẽêềếệểễìíịỉĩòóọỏõôồốộổỗơờớợởỡùúụủũưừứựửữỳýỵỷỹđ]{1,6})*$";
        return Pattern.compile(nameRegEx).matcher(name).matches();
    }

    public static boolean validateSex(String sex) {
        return sex.equals("Nam") ||
                sex.equals("Nữ") ||
                sex.equals("Khác");
    }

    /*  A valid national ID has 12 chars.
        3 first chars represent province code.
        The 4th follows:
        - Born 20th century -> 0 if male, 1 is female.
        - Born 21st century -> 2 if male, 3 is female, and so on.
        2 next chars represent year of birth, "YY" format.
        6 last are random, they said.
        I'm too lazy, so this only check the first condition.
     */
    public static boolean validateNationalId(String id) {
        return id.length() == 12;
    }
}
