import java.util.Scanner;

public class Kotuhi02{
    public static void main(String []args){
        
        Scanner scanner = new Scanner(System.in);
        
        //繰り返し処理
        boolean condition = true;
        int keiro_all_sum = 0;
        
        String[] keiro_names = {"魚住", "姫路", "三宮"};
        int[] keiro_prices = {1500, 2000, 300};
        int[] keiro_days = new int[3];
        int[] keiro_sums = new int[3];
        
        //駐輪場の使用有無
        int churinjo;
        int churin_price = 0;
        System.out.println("駐輪場は使いましたか");
        System.out.println("1:はい 2:いいえ");
        churinjo = scanner.nextInt();
        if(churinjo == 1){
            churin_price = 2400;
        }else if(churinjo == 2){
            churin_price = 0;
        }

        
        //経路選択と使用法
        while (condition) {

            System.out.println("経路を選択してください");
            System.out.println("1:魚住 2:姫路 3:三宮");
            int keiro = scanner.nextInt();
            
            String chosen_keiro = "";
            int keiro_price = 0;
            
            switch (keiro) {
                case 1:
                    chosen_keiro = "魚住";
                    keiro_price = 1500;
                    break;
                case 2:
                    chosen_keiro = "姫路";
                    keiro_price = 2000;
                    break;
                case 3:
                    chosen_keiro = "三宮";
                    keiro_price = 300;
                    break;
            }
            
            System.out.println("\n" + chosen_keiro + "ですね");
            
            //出勤日数の取得
            //合計金額の表示
            System.out.println("出勤日数を入力してください");
            int commute_days = scanner.nextInt();
            
            System.out.println("\n" + commute_days + "日ですね\n");
            
            int keiro_sum = (keiro_price * commute_days);
            
            System.out.println(chosen_keiro + "出勤の合計金額は" + keiro_sum + "円です");

            //入力を続けるか同どうかの処理
            System.out.println("入力を続けますか");
            System.out.println("はい:1 いいえ:0");
            int continue_or_not = scanner.nextInt();
            
            keiro_all_sum += (keiro_price * commute_days);
            
            if(continue_or_not == 1){
                System.out.println("継続します\n");
                condition = true;
                
                keiro_days[keiro - 1] += commute_days;
                keiro_sums[keiro - 1] += (keiro_price * commute_days);
                
            }else if(continue_or_not == 0){
                System.out.println("終了します\n");
                condition = false;
                
                for (int i=0; i<3; i++) {
                    System.out.println(keiro_names[i] + "出勤" + keiro_days[i] + "日" + keiro_sums[i] + "円");
                }
                System.out.println("駐輪所"+ churin_price + "円");
                
                keiro_all_sum += churin_price;
                
                System.out.println("総合計金額は" + keiro_all_sum + "円です");
                
            }
        }
        scanner.close();
    }
}
