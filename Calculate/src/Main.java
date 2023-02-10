import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static String calc(String input){
        boolean rim = false;
        int res = 0;
        Scanner x = new Scanner(System.in);
        String math = x.nextLine();
        x.close();
        ThrowsExp.exp(math);
        char[] operation = math.toCharArray();
        for (char sym: operation){
            switch (sym){
                case 'I': rim = true; break;
                case 'V': rim = true; break;
                case 'X': rim = true; break;
            }
        }
        if (rim){
            math = Rome.convert(math);
        } else {
        for (char sym: operation){
            switch (sym){
                case '+': res = Summ.add(math);
                    break;
                case '-': res = Summ.sub(math);
                    break;
                case '*': res = Summ.mul(math);
                    break;
                case '/': res = Summ.div(math);
                    break;
            }
        }
        }
        if (rim) {
            math = Rome.inverter(math);
            return math;
        } else {
            return Integer.toString(res);
        }
    }

    public static void main(String[] x) {
        System.out.println(calc(""));
    }

}

class ThrowsExp{
    static void exp(String math){
        boolean dec = false;
        boolean oper = false;
        boolean arr = false;
        boolean rim = false;
        String prov = "";
        int p1 = 0;
        char[] operation = math.toCharArray();
        for (char i: operation){
            switch (i){
                case '1': arr=true;
                    break;
                case '2': arr=true;
                    break;
                case '3': arr=true;
                    break;
                case '4': arr=true;
                    break;
                case '5': arr=true;
                    break;
                case '6': arr=true;
                    break;
                case '7': arr=true;
                    break;
                case '8': arr=true;
                    break;
                case '9': arr=true;
                    break;
                case '0': arr=true;
                    break;
                case 'I': rim=true;
                    break;
                case 'V': rim=true;
                    break;
                case 'X': rim=true;
                    break;
            }
        }
        if(arr) {
            for (char i : operation) {
                switch (i) {
                    case '1':
                        prov = prov + "1";
                        break;
                    case '2':
                        prov = prov + "2";
                        break;
                    case '3':
                        prov = prov + "3";
                        break;
                    case '4':
                        prov = prov + "4";
                        break;
                    case '5':
                        prov = prov + "5";
                        break;
                    case '6':
                        prov = prov + "6";
                        break;
                    case '7':
                        prov = prov + "7";
                        break;
                    case '8':
                        prov = prov + "8";
                        break;
                    case '9':
                        prov = prov + "9";
                        break;
                    case '0':
                        prov = prov + "0";
                        break;
                    default:
                        if (p1 == 0) {
                            p1 = Integer.parseInt(prov);
                            prov = "";
                        }
                }
            }
            if (p1>10 || Integer.parseInt(prov)>10){
                try {
                    throw new IOException();
                } catch (IOException e) {
                    System.out.println("throws Exception");
                    System.exit(0);
                }
            }
        }
        if (rim == arr){
            try {
            throw new IOException();
        } catch (IOException e) {
            System.out.println("throws Exception");
            System.exit(0);
        }
        }
        for (char i: operation){
            switch (i){
                case '+': oper=true;
                    break;
                case '-': oper=true;
                    break;
                case '*': oper=true;
                    break;
                case '/': oper=true;
                    break;
            }
        }
        if (oper){oper=false;} else {
            try {
                throw new IOException();
            } catch (IOException e) {
                System.out.println("throws Exception");
                System.exit(0);
            }
        }
        for (char i: operation){
            switch (i){
                case '1': dec = true; break;
                case '0': if (dec){
                    dec=false;
                } else {
                    try{
                        throw new IOException();
                    } catch (IOException e){
                        System.out.println("throws Exception");
                        System.exit(0);
                    }
                }
                    break;
                case '+':
                    if (!oper){oper=true;} else {
                        try {
                            throw new IOException();
                        } catch (IOException e) {
                            System.out.println("throws Exception");
                            System.exit(0);
                        }
                    }
                    break;
                case '-':
                    if (!oper){oper=true;} else {
                        try {
                            throw new IOException();
                        } catch (IOException e) {
                            System.out.println("throws Exception");
                            System.exit(0);
                        }
                    }
                    break;
                case '*':
                    if (!oper){oper=true;} else {
                        try {
                            throw new IOException();
                        } catch (IOException e) {
                            System.out.println("throws Exception");
                            System.exit(0);
                        }
                    }
                    break;
                case '/':
                    if (!oper){oper=true;} else {
                        try {
                            throw new IOException();
                        } catch (IOException e) {
                            System.out.println("throws Exception");
                            System.exit(0);
                        }
                    }
                    break;
            }
        }
    }
}

class Rome{
    static String convert(String con){
        int result = 0;
        int x1 = 0;
        int x2 = 0;
        int res = 0;
        String math;
        boolean k = false;
        boolean erro1 = false;
        boolean erro2 = false;
        char[] operation = con.toCharArray();
        for (char i: operation) {
            switch (i){
                case 'I': result++; k = true;
                    if(erro1){erro2=true;}
                    break;
                case 'V': if (k){
                    result = result + 3;
                } else { result = result + 5;}
                    if(erro1){erro2=true;}
                    break;
                case 'X': if (k){
                    result = result + 8;
                } else { result = result + 10;}
                    erro1=true;
                    break;
                default: k = false;
                if (x1 == 0){x1 = result;}
            }
            x2 = result - x1;
        }
        if (erro2){
            try {
            throw new IOException();
        } catch (IOException e) {
            System.out.println("throws Exception");
            System.exit(0);
        }
        }
        for (char sym: operation){
            switch (sym){
                case '+':
                    math = Integer.toString(x1)+"+"+Integer.toString(x2);
                    res = Summ.add(math);
                    break;
                case '-':
                    math = Integer.toString(x1)+"-"+Integer.toString(x2);
                    res = Summ.sub(math);
                    break;
                case '*':
                    math = Integer.toString(x1)+"*"+Integer.toString(x2);
                    res = Summ.mul(math);
                    break;
                case '/':
                    math = Integer.toString(x1)+"/"+Integer.toString(x2);
                    res = Summ.div(math);
                    break;
            }
        }
        return Integer.toString(res);
    }
    static String inverter(String inv){
        int x = Integer.parseInt(inv);
        switch (x){
            case 100 : inv = "C";
                break;
            case 90 : inv = "XC";
                break;
            case 80 : inv = "LXXX";
                break;
            case 70 : inv = "LXX";
                break;
            case 60 : inv = "LX";
                break;
            case 50 : inv = "L";
                break;
            case 40 : inv = "XL";
                break;
            case 30 : inv = "XXX";
                break;
            case 20 : inv = "XX";
                break;
            case 19 : inv = "IXX";
                break;
            case 18 : inv = "XVIII";
                break;
            case 17 : inv = "XVII";
                break;
            case 16 : inv = "XVI";
                break;
            case 15 : inv = "XV";
                break;
            case 14 : inv = "XIV";
                break;
            case 13 : inv = "XIII";
                break;
            case 12 : inv = "XII";
                break;
            case 11 : inv = "XI";
                break;
            case 10 : inv = "X";
                break;
            case 9 : inv = "IX";
                break;
            case 8 : inv = "VIII";
                break;
            case 7 : inv = "VII";
                break;
            case 6 : inv = "VI";
                break;
            case 5 : inv = "V";
                break;
            case 4 : inv = "IV";
                break;
            case 3 : inv = "III";
                break;
            case 2 : inv = "II";
                break;
            case 1 : inv = "I";
                break;
            default:
                try {
                    throw new IOException();
                } catch (IOException e) {
                    System.out.println("throws Exception");
                    System.exit(0);
                }

        }
        return inv;
    }
}

class Summ{
    static int add(String op){
        int result = 0;
        boolean k = false;
        char[] operation = op.toCharArray();
        for (char i: operation) {
            switch (i){
                case '1': result += 1; k = true;
                    break;
                case '2': result += 2;
                    break;
                case '3': result += 3;
                    break;
                case '4': result += 4;
                    break;
                case '5': result += 5;
                    break;
                case '6': result += 6;
                    break;
                case '7': result += 7;
                    break;
                case '8': result += 8;
                    break;
                case '9': result += 9;
                    break;
                case '0': if (k){
                    result = result + 9;
                    k = false;
                }
                    break;
                default: k = false;
            }
        }
        return result;
    }
    static int sub(String op){
        int result = 0;
        boolean k = false;
        char[] operation = op.toCharArray();
        for (char i: operation) {
            if (result == 1 && i == '0'){result= result + 9;}
            if (result == 0){
                result = Character.digit(i,10);
            } else {
                switch (i) {
                    case '1':
                        result -= 1;
                        k = true;
                        break;
                    case '2':
                        result -= 2;
                        break;
                    case '3':
                        result -= 3;
                        break;
                    case '4':
                        result -= 4;
                        break;
                    case '5':
                        result -= 5;
                        break;
                    case '6':
                        result -= 6;
                        break;
                    case '7':
                        result -= 7;
                        break;
                    case '8':
                        result -= 8;
                        break;
                    case '9':
                        result -= 9;
                        break;
                    case '0':
                        if (k) {
                            result = result - 9;
                            k = false;
                        }
                        break;
                    default:
                        k = false;
                }
            }
        }
        return result;
    }
    static int mul(String op){
        int result = 0;
        boolean k = false;
        char[] operation = op.toCharArray();
        for (char i: operation) {
            if (result == 1 && i == '0'){result= result + 9;}
            if (result == 0){
                result = Character.digit(i,10);
            } else {
                switch (i) {
                    case '1':
                        result *= 1;
                        k = true;
                        break;
                    case '2':
                        result *= 2;
                        break;
                    case '3':
                        result *= 3;
                        break;
                    case '4':
                        result *= 4;
                        break;
                    case '5':
                        result *= 5;
                        break;
                    case '6':
                        result *= 6;
                        break;
                    case '7':
                        result *= 7;
                        break;
                    case '8':
                        result *= 8;
                        break;
                    case '9':
                        result *= 9;
                        break;
                    case '0':
                        if (k) {
                            result *= 10;
                            k = false;
                        }
                        break;
                    default:
                        k = false;
                }
            }
        }
        return result;
    }
    static int div(String op){
        int result = 0;
        boolean k = false;
        char[] operation = op.toCharArray();
        for (char i: operation) {
            if (result == 1 && i == '0'){result= result + 9;}
            if (result == 0){
                result = Character.digit(i,10);
            } else {
                switch (i) {
                    case '1':
                        result /= 1;
                        k = true;
                        break;
                    case '2':
                        result /= 2;
                        break;
                    case '3':
                        result /= 3;
                        break;
                    case '4':
                        result /= 4;
                        break;
                    case '5':
                        result /= 5;
                        break;
                    case '6':
                        result /= 6;
                        break;
                    case '7':
                        result /= 7;
                        break;
                    case '8':
                        result /= 8;
                        break;
                    case '9':
                        result /= 9;
                        break;
                    case '0':
                        if (k) {
                            result /= 10;
                            k = false;
                        }
                        break;
                    default:
                        k = false;
                }
            }
        }
        return result;
    }
}