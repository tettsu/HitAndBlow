package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HitAndBlow {

	public static void main(String[] args) {
		//変数の初期化
		String title = "HitAndBlow";
		String rule_description = "隠された3つの数字を当てます。"
				+ "1つの数字は1～6の間です。"
				+ "答えの数字の中で重複が起きることはありません。"
				+ "入力した数字と位置が両方一致していればHit、"
				+ "数字だけがあっていたらBlowとカウントします。"
				+ "全てHitさせることができれば終了です。";
		int[] answer 	= new int[3];
		int[] input = new int[3];

		int hit = 0;
		int blow = 0;
		int count = 0;

		//タイトルとルールの説明
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println(title);
		System.out.println(rule_description);

		//ランダムな答えの生成
		//同じ数字は含まないようにする
		for (int i = 0; i < answer.length; i++){
			//自分より前の数字の要素に同じものが無いか確認する。
			//あった場合はもう一回random
			boolean flag = false;
			answer[i] = (int)(Math.random() * 6 + 1);
			do {
				flag = false;
				for (int j = i - 1 ; j >= 0; j--){
					if(answer[i] == answer[j]){
						flag = true;
						answer[i] = (int)(Math.random() * 6 + 1);
					}
				}
			}while(flag == true);
		}

		//メイン処理
		//入力させる。数値のチェックを行う。
		while (true){
			count++;
			System.out.println(count+"回目");
			//インプット
			for(int i = 0; i < answer.length; i++){
				System.out.println((i+1)+"個目");
				try{
					input[i] = Integer.parseInt(br.readLine());
				}catch(NumberFormatException e){
					System.err.println("数値を入力してください！");
					i--;
				}catch(IOException e){
					System.err.println("もう一度入力してください。");
					i--;
				}
			}
		//答え判断
		hit = 0;
		blow = 0;
		for(int i = 0; i < answer.length; i++){
			for(int j = 0; j < answer.length; j++){
				if ( i == j && input[i] == answer[j]){
					hit++;
				} else if(input[i] == answer[j]){
					blow++;
				}
			}
		}

		//終了判断
		System.out.println("Hit"+hit+"Blow"+blow);
		if(hit == 3){
			System.out.println("Congratuation!!!!!!!!!!!!!!!!");
			break;
		}else{
			System.out.println();
		}
	}
	}
}
