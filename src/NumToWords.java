// https://stackoverflow.com/questions/35416641/numbers-to-words-in-python

public class NumToWords {
    public static String get_ones(int num) {
        return switch (num) {
            case 1 -> "One "; case 2 -> "Two "; case 3 -> "Three "; case 4 -> "Four "; case 5 -> "Five ";
            case 6 -> "Six "; case 7 -> "Seven "; case 8 -> "Eight "; case 9 -> "Nine "; case 10 -> "Ten ";
            case 11 -> "Eleven "; case 12 -> "Twelve "; case 13 -> "Thirteen "; case 14 -> "Fourteen "; case 15 -> "Fifteen ";
            case 16 -> "Sixteen "; case 17 -> "Seventeen "; case 18 -> "Eighteen "; case 19 -> "Nineteen ";
            default -> "";
        };
    }

    public static String get_tens(int num) {
        return switch (num) {
            case 2 -> "Twenty "; case 3 -> "Thirty "; case 4 -> "Forty "; case 5 -> "Fifty ";
            case 6 -> "Sixty "; case 7 -> "Seventy "; case 8 -> "Eighty "; case 9 -> "Ninety ";
            default -> "";
        };
    }
    public static String convert_num(int num){
        String num_words;
        if (num <= 19){
            num_words = get_ones(num);
            return num_words;
        }
        if (num < 100) {
            num_words = get_tens(Math.floorDiv(num, 10)) + get_ones(num % 10);
            return num_words;
        }
        if (num < 1000){
            num_words = get_ones(Math.floorDiv(num, 100)) + "Hundred " + convert_num(num % 100);
            return num_words;
        }
        if (num < 1000000){
            num_words = convert_num(Math.floorDiv(num, 1000)) + "Thousand " + convert_num(num % 1000);
            return num_words;
        }
        if (num < 1000000000){
            num_words = convert_num(Math.floorDiv(num, 1000000)) + "Million " + convert_num(num % 1000000);
            return num_words;
        }
        return convert_num(Math.floorDiv(num, 1000000000)) + "Billion " + convert_num(num % 1000000000);
    }
}
