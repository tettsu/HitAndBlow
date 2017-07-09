package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.swing.JOptionPane;

import constants.Sentence;

public class HitAndBlow {

	public static void main(String[] args) {
		//変数の初期化
		int[] answer 	= new int[3];
		int[] input = new int[3];

		int hit = 0;
		int blow = 0;
		int count = 0;

		//タイトルとルールの説明
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println(Sentence.GAME_TITLE);
		System.out.println(Sentence.LINE);
		System.out.println(Sentence.RULE_DESCRIPTION_TITLE);
		System.out.println(Sentence.RULE_DESCRIPTION1);
		System.out.println(Sentence.RULE_DESCRIPTION2);
		System.out.println(Sentence.RULE_DESCRIPTION3);
		System.out.println(Sentence.RULE_DESCRIPTION4);
		System.out.println(Sentence.RULE_DESCRIPTION5);
		System.out.println(Sentence.LINE);

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
			System.out.println(count+Sentence.CHALLENGE_COUNT);
			//インプット
			for(int i = 0; i < answer.length; i++){
				System.out.print((i+1)+Sentence.INDEX_OF_INPUTS);
				try{
					input[i] = Integer.parseInt(br.readLine());
				}catch(NumberFormatException e){
					System.err.println(Sentence.PLEASE_ENTER_NUMBER);
					i--;
				}catch(IOException e){
					System.err.println(Sentence.PLEASE_ENTER_SOMETHING);
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
			System.out.println(Sentence.HIT_COUNTS+hit);
			System.out.println(Sentence.BLOW_COUNTS+blow);
			if(hit == 3){
				System.out.println(Sentence.CONGRATULATION_MESSAGE);
				break;
			}else{
				System.out.println(Sentence.RETRY_MESSAGE);
				System.out.println(Sentence.LINE);
				JOptionPane.showMessageDialog(null, Sentence.RETRY_MESSAGE, "Retry!!", JOptionPane.INFORMATION_MESSAGE, null);
			}
		}
	}
}
