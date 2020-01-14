package sua;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Calendar; 
import java.util.GregorianCalendar;
import java.util.List;

import javafx.animation.*;
import javafx.application.Application;
import javafx.event.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.control.Label;
import javafx.scene.image.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.scene.text.*;
import javafx.geometry.Insets;
import javafx.geometry.*;
import javafx.stage.*;
import javafx.util.Duration;


public class project extends Application{
	
	private String name=" ";
	private Button btn1;
	private Button btn2;
	private Button btn3;
	private Button btn4;
	private Button Pfbtn;
	private Button Lcbtn;
	private Button Tcbtn;
	private Button Cdbtn;
	private TextField nameTf;
	private String locate;
	private int locateN;
	private String destin;
	private int destinN;
	private ArrayList<String> Lline = new ArrayList<>(
			Arrays.asList("위치를 설정해주세요","위치를 설정해주세요","위치를 설정해주세요",
					"위치를 설정해주세요","위치를 설정해주세요","위치를 설정해주세요","위치를 설정해주세요","위치를 설정해주세요"));
	
	@Override
	public void start(Stage PrimaryStage) {
		
		btn1 = new Button("프로필 관리 및 도움말");
		btn2 = new Button("현재 위치 설정");
		btn3 = new Button("배차시간 확인");
		btn4 = new Button("내 교통카드");
		
		StackPane MainPn = new StackPane();
		
		Rectangle BgLi1 = new Rectangle(980,480);
		BgLi1.setStroke(Color.SKYBLUE);
		BgLi1.setStrokeWidth(10);
		BgLi1.setFill(Color.color(0, 0, 0, 0));
		
		Rectangle BgLi2 = new Rectangle(940,440);
		BgLi2.setStroke(Color.SKYBLUE);
		BgLi2.setStrokeWidth(10);
		BgLi2.setFill(Color.color(0, 0, 0, 0));
		
		
		MainPn.getChildren().addAll(BgLi1,BgLi2,new Main());
		Scene scene1 = new Scene(MainPn,1000,500);
		
		PrimaryStage.setTitle("Sua Project");
		PrimaryStage.setScene(scene1);
		PrimaryStage.show();
		
		Stage stage2 = new Stage();
		Pfbtn = new Button("입력 완료");
		nameTf = new TextField();
		Scene sceneP = new Scene(new ProfilePn(),1000,500);
		stage2.setScene(sceneP);
		stage2.setTitle("Sua Project");
		
		Stage stage3 = new Stage();
		Scene sceneL = new Scene(new LocationPn(),1000,500);
		stage3.setScene(sceneL);
		stage3.setTitle("Sua Project");
		
		Stage stage4 = new Stage();
		Scene sceneT = new Scene(new Timecheck(),1000,500);
		stage4.setScene(sceneT);
		stage4.setTitle("Sua Project");
		
		Stage stage5 = new Stage();
		Scene sceneC = new Scene(new CardPn(),1000,500);
		stage5.setScene(sceneC);
		stage5.setTitle("Sua Project");
		
		
		btn1.setOnAction(e -> {
			PrimaryStage.close();
			stage2.show();
		});
		btn2.setOnAction(e -> {
			PrimaryStage.close();
			stage3.show();
		});
		btn3.setOnAction(e -> {
			PrimaryStage.close();
			stage4.show();
		});
		btn4.setOnAction(e -> {
			PrimaryStage.close();
			stage5.show();
		});
		
		
		Pfbtn.setOnAction(e -> {
			name = new String(nameTf.getText());
			stage2.close();
			PrimaryStage.show();
		});
		
		Lcbtn.setOnAction(e -> {
			stage3.close();
			PrimaryStage.show();
		});
		
		Tcbtn.setOnAction(e -> {
			stage4.close();
			PrimaryStage.show();
		});
		Cdbtn.setOnAction(e -> {
			stage5.close();
			PrimaryStage.show();
		});
	}
		
		public static void main(String[] args)
		{
			launch(args);
		}
		
	class Main extends VBox {
		public Main() {
					
			Text Title = new Text("Easy-Transport");
			Title.setFont(Font.font("SansSerif", FontWeight.BOLD, FontPosture.ITALIC, 40));
			Title.setFill(Color.DEEPSKYBLUE);
			getChildren().add(Title);
			
			setPadding(new Insets(100,50,50,350));
			setMargin(Title, new Insets(20,20,20,20));
			
			getChildren().addAll(btn1,btn2,btn3,btn4);
			
			setMargin(btn1, new Insets(15,15,15,90));
			setMargin(btn2, new Insets(15,15,15,110));
			setMargin(btn3, new Insets(15,15,15,110));
			setMargin(btn4, new Insets(15,15,15,115));
			
		}
	}
		
	class ProfilePn extends GridPane {
		public ProfilePn() {
			setAlignment(Pos.CENTER);
			
			
			setHgap(5);
			setVgap(5);
			
			ImageView pfIm = new ImageView(new Image("image/profile.png"));
			pfIm.setFitHeight(150);
			pfIm.setFitWidth(150);
			
			add(pfIm, 1, 0);
			add(new Label("이름 : "),0,1);
			add(nameTf,1,1);
			add(new Label("나이 : "),0,2);
			add(new TextField(),1,2);
			add(new Label("연락처 : "),0,3);
			add(new TextField(),1,3);
			add(new Label("이메일 : "),0,4);
			add(new TextField(),1,4);
			add(new Label("주소 : "),0,5);
			add(new TextField(),1,5);
			add(Pfbtn, 1, 6);
		}
	}
	
	class LocationPn extends BorderPane {
		
		private String line;
		private ComboBox<String> cboM = new ComboBox<>();
		private ComboBox<String> cboL = new ComboBox<>();
		private ComboBox<String> cboS = new ComboBox<>();
		
		public LocationPn() {
			
			setPadding(new Insets(30,20,20,30));
			
			ImageView MtIm = new ImageView(new Image("image/metro.png"));
			MtIm.setFitHeight(430);
			MtIm.setFitWidth(600);
			setLeft(MtIm);
			
			VBox LcBox = new VBox();
			
			
			cboM.getItems().addAll("1호선","2호선","3호선","분당선");
			cboM.setValue("---라인을 선택하세요---");
			
			cboL.getItems().addAll("라인을 먼저 선택하세요");
			cboL.setValue("---현재위치(출발역)---");
			
			cboS.getItems().addAll("라인을 먼저 선택하세요");
			cboS.setValue("---목표위치(도착역)---");
			
			Lcbtn = new Button("선택 완료");
			
			LcBox.getChildren().addAll(cboM,cboL,cboS,Lcbtn);
			LcBox.setMargin(cboM, new Insets(40,20,20,90));
			LcBox.setMargin(cboL, new Insets(40,20,20,95));
			LcBox.setMargin(cboS, new Insets(40,20,20,95));
			LcBox.setMargin(Lcbtn, new Insets(60,20,20,150));
			setCenter(LcBox);
			
			cboM.setOnAction( e -> {
				line = cboM.getValue();
			
			if(line == "1호선") {
				cboL.getItems().addAll("광운대","석계","신이문","외대앞","회기","청량리","제기동","신설동");
				Lline.add(0,"광운대"); Lline.add(1,"석계"); Lline.add(2,"신이문"); Lline.add(3,"외대앞");
				Lline.add(4,"회기"); Lline.add(5,"청량리"); Lline.add(6,"제기동"); Lline.add(7,"신설동");
				
				cboS.getItems().addAll("광운대","석계","신이문","외대앞","회기","청량리","제기동","신설동");
				Lline.add(0,"광운대"); Lline.add(1,"석계"); Lline.add(2,"신이문"); Lline.add(3,"외대앞");
				Lline.add(4,"회기"); Lline.add(5,"청량리"); Lline.add(6,"제기동"); Lline.add(7,"신설동");
				
				cboL.setOnAction( new SelectL() );
				cboS.setOnAction( new SelectS() );
				
			}
			else if(line == "2호선") {
				cboL.getItems().addAll("상왕십리","왕십리","한양대","뚝섬","성수","건대입구","구의","강변");
				Lline.add(0,"상왕십리"); Lline.add(1,"왕십리"); Lline.add(2,"한양대"); Lline.add(3,"뚝섬");
				Lline.add(4,"성수"); Lline.add(5,"건대입구"); Lline.add(6,"구의"); Lline.add(7,"강변");
				
				cboS.getItems().addAll("상왕십리","왕십리","한양대","뚝섬","성수","건대입구","구의","강변");
				Lline.add(0,"상왕십리"); Lline.add(1,"왕십리"); Lline.add(2,"한양대"); Lline.add(3,"뚝섬");
				Lline.add(4,"성수"); Lline.add(5,"건대입구"); Lline.add(6,"구의"); Lline.add(7,"강변");
				
				cboL.setOnAction( new SelectL() );
				cboS.setOnAction( new SelectS() );
			}
			else if(line == "3호선") {
				cboL.getItems().addAll("을지로3가","충무로","약수","금호","옥수","압구정","신사","잠원");
				Lline.add(0,"을지로3가"); Lline.add(1,"충무로"); Lline.add(2,"약수"); Lline.add(3,"금호");
				Lline.add(4,"옥수"); Lline.add(5,"압구정"); Lline.add(6,"신사"); Lline.add(7,"잠원");
				
				cboS.getItems().addAll("을지로3가","충무로","약수","금호","옥수","압구정","신사","잠원");
				Lline.add(0,"을지로3가"); Lline.add(1,"충무로"); Lline.add(2,"약수"); Lline.add(3,"금호");
				Lline.add(4,"옥수"); Lline.add(5,"압구정"); Lline.add(6,"신사"); Lline.add(7,"잠원");
				
				cboL.setOnAction( new SelectL() );
				cboS.setOnAction( new SelectS() );
			}
			else if(line == "분당선") {
				cboL.getItems().addAll("서울숲","압구정로데오","강남구청","선정릉","선릉","한티","도곡","구룡");
				Lline.add(0,"서울숲"); Lline.add(1,"압구정로데오"); Lline.add(2,"강남구청"); Lline.add(3,"선정릉");
				Lline.add(4,"선릉"); Lline.add(5,"한티"); Lline.add(6,"도곡"); Lline.add(7,"구룡");
				
				cboS.getItems().addAll("서울숲","압구정로데오","강남구청","선정릉","선릉","한티","도곡","구룡");
				Lline.add(0,"서울숲"); Lline.add(1,"압구정로데오"); Lline.add(2,"강남구청"); Lline.add(3,"선정릉");
				Lline.add(4,"선릉"); Lline.add(5,"한티"); Lline.add(6,"도곡"); Lline.add(7,"구룡");
				
				cboL.setOnAction( new SelectL() );
				cboS.setOnAction( new SelectS() );
			}
			});
		}
		
		class SelectL implements EventHandler<ActionEvent> {
			@Override
			public void handle(ActionEvent e) {
				locate = cboL.getValue();
				locateN = Lline.indexOf(locate);
			}
		}
		class SelectS implements EventHandler<ActionEvent> {
			@Override
			public void handle(ActionEvent e) {
				destin = cboS.getValue();
				destinN = Lline.indexOf(destin);
			}
		}
	}
	
	class Timecheck extends Pane {
		
		private int findSt1, findSt2, findSt3, findSt4;
		private int hour,hour1;
		private int minute,minute1;
		private int second,second1;
		private Text Timetexts;
		private String Wait1, Wait2, Wait3, Wait4, Wait5;
		private int WaitN1 = 30,WaitN2 = 60,WaitN3 = 90,WaitN4 = 120,WaitN5 = 150;
		private Text WaitText1,WaitText2,WaitText3,WaitText4,WaitText5;
		private Text station1, station2, station3, station4, station5;
		
		public Timecheck() {
			
			Tcbtn = new Button("---확인 완료---");
			
			if(destinN>=locateN) { 
				findSt1=-2; findSt2=-1; findSt3=1; findSt4=2;
				if(locateN==0) { findSt1=0; findSt2=0; }
				else if(locateN==1) { findSt1=0; }
				else if(locateN==6) { findSt4=0; }
				else if(locateN==7) { findSt3=0; findSt4=0; }
			}
			else {
				findSt1=2; findSt2=1; findSt3=-1; findSt4=-2;
				if(locateN==0) { findSt1=0; findSt2=0; }
				else if(locateN==1) { findSt1=0; }
				else if(locateN==6) { findSt4=0; }
				else if(locateN==7) { findSt3=0; findSt4=0; }
			}
			
			Circle cc = new Circle(500,100,15);
			cc.setStrokeWidth(10);
			cc.setStroke(Color.RED);
			FadeTransition ft = new FadeTransition(Duration.millis(1000),cc);
			ft.setFromValue(1.0);
			ft.setToValue(0.1);
			ft.setCycleCount(Timeline.INDEFINITE);
			ft.setAutoReverse(true);
			ft.play();
			
			
			Circle[] circles = {new Circle(100,100,10), new Circle(300,100,10),cc,
					new Circle(700,100,10), new Circle(900,100,10)};
			for(Circle circle : circles) {
				circle.setFill(Color.BLACK);
				getChildren().add(circle);
			}
			
			ImageView SwIm = new ImageView(new Image("image/subway.png"));
			ImageView SwIm2 = new ImageView(new Image("image/subway.png"));
			SwIm.setFitWidth(100);
			SwIm.setFitHeight(55);
			SwIm2.setFitWidth(100);
			SwIm2.setFitHeight(55);
			
			Line swline1 = new Line(0,100,1000,100);
			Line swline2 = new Line(0,70,500,70);
			Line swline3 = new Line(500,70,1000,70);
			swline2.setStroke(Color.color(0, 0, 0, 0));
			swline3.setStroke(Color.color(0, 0, 0, 0));
			swline1.setStrokeWidth(5);
			
			PathTransition pt = new PathTransition();
			pt.setPath(swline2);
			pt.setNode(SwIm);
			pt.setDuration(Duration.millis(30000));
			pt.setCycleCount(Timeline.INDEFINITE);
			pt.play();
			
			PathTransition pt2 = new PathTransition();
			pt2.setPath(swline3);
			pt2.setNode(SwIm2);
			pt2.setDuration(Duration.millis(30000));
			pt2.setCycleCount(Timeline.INDEFINITE);
			pt2.play();
			
			getChildren().addAll(swline1,swline2,SwIm,SwIm2);
			
			EventHandler<ActionEvent> eventHandler = e -> {
				
				getChildren().removeAll(station1, station2, station3, station4, station5);
				station3 = new Text(500,120,locate);
				station4 = new Text(700,120,Lline.get(locateN+findSt3).toString());
				station5 = new Text(900,120,Lline.get(locateN+findSt4).toString());
				
				getChildren().addAll(station3, station4, station5);
				
				getChildren().remove(Timetexts);
				Calendar calendar = new GregorianCalendar();
				
				this.hour = calendar.get(Calendar.HOUR_OF_DAY);
			    this.minute = calendar.get(Calendar.MINUTE);
			    this.second = calendar.get(Calendar.SECOND);
			    
			    String Timetext = "현재시각 : " + hour + " : " + minute + " : " + second;
				Timetexts = new Text(250,190,Timetext);
				Timetexts.setFont(Font.font("monospace", FontWeight.BOLD, FontPosture.ITALIC, 40));
			
				getChildren().add(Timetexts);
			};
			Timeline Timeani = new Timeline(new KeyFrame(Duration.millis(1000), eventHandler));
			Timeani.setCycleCount(Timeline.INDEFINITE);
			Timeani.play();
			
			VBox Sbtime1 = new VBox();
			Text[] sbtime1 = {new Text("다음 열차"),new Text("다음 열차"),new Text("다음 열차"),
					new Text("다음 열차"),new Text("다음 열차")};
			for(Text sbtimes1 : sbtime1) {
				sbtimes1.setFont(Font.font(20));
				Sbtime1.setMargin(sbtimes1, new Insets(13,13,13,13));
				Sbtime1.getChildren().add(sbtimes1);
			}
			Sbtime1.setPadding(new Insets(210,0,0,250));
			getChildren().add(Sbtime1);
			
			VBox Sbtime2 = new VBox();
		    
			setTime(30);
		    String NTimetext1 = hour1 + " : " + minute1 + " : " + second1;
		    setTime(60);
		    String NTimetext2 = hour1 + " : " + minute1 + " : " + second1;
		    setTime(90);
		    String NTimetext3 = hour1 + " : " + minute1 + " : " + second1;
		    setTime(120);
		    String NTimetext4 = hour1 + " : " + minute1 + " : " + second1;
		    setTime(150);
		    String NTimetext5 = hour1 + " : " + minute1 + " : " + second1;
		    
		    Text[] sbtime2 = {new Text(NTimetext1),new Text(NTimetext2),new Text(NTimetext3),
		    		new Text(NTimetext4),new Text(NTimetext5),};
		    
		    for(Text sbtimes2 : sbtime2) {
		    	sbtimes2.setFont(Font.font(20));
		    	Sbtime2.setMargin(sbtimes2, new Insets(13,13,13,13));
		    	Sbtime2.getChildren().add(sbtimes2);
		    }
		    Sbtime2.setPadding(new Insets(210,0,0,400));
		    Sbtime2.getChildren().add(Tcbtn);
		    getChildren().add(Sbtime2);
		    
		    
		    VBox Sbtime3 = new VBox();
		    
		    EventHandler<ActionEvent> eventHandler2 = e -> {
		    	Sbtime3.getChildren().remove(WaitText1);
		    	Sbtime3.getChildren().remove(WaitText2);
		    	Sbtime3.getChildren().remove(WaitText3);
		    	Sbtime3.getChildren().remove(WaitText4);
		    	Sbtime3.getChildren().remove(WaitText5);
		    	
		    	WaitN1--; WaitN2--; WaitN3--;WaitN4--; WaitN5--;
		    			    	
			    if(WaitN1<=0) { Wait1 = "열차 도착"; }
			    else { Wait1 = WaitN1 + "초 후 도착"; }
			    
			    WaitText1 = new Text(Wait1);
			    WaitText1.setFont(Font.font(20));
			    Sbtime3.setMargin(WaitText1,new Insets(13,13,13,13));
			    if(WaitN1 <=30 ) {
			    	WaitText1.setFill(Color.RED);
			    }
			    Sbtime3.getChildren().add(WaitText1);
			    
			    if(WaitN2<=0) { Wait2 = "열차 도착"; }
			    else { Wait2 = WaitN2 + "초 후 도착"; }
			    
			    WaitText2 = new Text(Wait2);
			    WaitText2.setFont(Font.font(20));
			    Sbtime3.setMargin(WaitText2,new Insets(13,13,13,13));
			    if(WaitN2 <=30 ) {
			    	WaitText2.setFill(Color.RED);
			    }
			    Sbtime3.getChildren().add(WaitText2);
			    
			    if(WaitN3<=0) { Wait3 = "열차 도착"; }
			    else { Wait3 = WaitN3 + "초 후 도착"; }
			    
			    WaitText3 = new Text(Wait3);
			    WaitText3.setFont(Font.font(20));
			    Sbtime3.setMargin(WaitText3,new Insets(13,13,13,13));
			    if(WaitN3 <=30 ) {
			    	WaitText1.setFill(Color.RED);
			    }
			    Sbtime3.getChildren().add(WaitText3);
			    
			    if(WaitN4<=0) { Wait4 = "열차 도착"; }
			    else { Wait4 = WaitN4 + "초 후 도착"; }
			    
			    WaitText4 = new Text(Wait4);
			    WaitText4.setFont(Font.font(20));
			    Sbtime3.setMargin(WaitText4,new Insets(13,13,13,13));
			    if(WaitN4 <=30 ) {
			    	WaitText4.setFill(Color.RED);
			    }
			    Sbtime3.getChildren().add(WaitText4);
			    
			    if(WaitN5<=0) { Wait5 = "열차 도착"; }
			    else { Wait5 = WaitN5 + "초 후 도착"; }
			    
			    WaitText5 = new Text(Wait5);
			    WaitText5.setFont(Font.font(20));
			    Sbtime3.setMargin(WaitText5,new Insets(13,13,13,13));
			    if(WaitN5 <=30 ) {
			    	WaitText5.setFill(Color.RED);
			    }
			    Sbtime3.getChildren().add(WaitText5);
			    
		    };
		   
		    Timeline Timeani2 = new Timeline(new KeyFrame(Duration.millis(1000), eventHandler2));
			Timeani2.setCycleCount(Timeline.INDEFINITE);
			Timeani2.play();
			Sbtime3.setPadding(new Insets(210,0,0,600));
	    	getChildren().add(Sbtime3);
		}
		
		public void setTime(int n) {
			Calendar calendar = new GregorianCalendar();
			
			long calendar2 = calendar.getTimeInMillis() + n*1000;
			
			this.hour1 = (int)calendar2/(1000*60*60);
		    this.minute1 = (int)(calendar2%(1000*60*60))/(1000*60);
		    this.second1 = (int)(calendar2%(1000*60))/1000;
		}
	}
	
	class CardPn extends Pane {
		
		private int Money = 0;
		private String ctxt2;
		private Text Ctxt2;
		private Text Ctxt1;
		
		public CardPn() {
			
			ImageView CdIm = new ImageView(new Image("image/Card.png"));
			CdIm.setLayoutX(100);
			CdIm.setLayoutY(100);
			CdIm.setFitHeight(250);
			CdIm.setFitWidth(400);
			getChildren().add(CdIm);
			
			EventHandler<ActionEvent> eventHandler = e -> {
				
				getChildren().remove(Ctxt1);
				String ctxt1 = "\" " + name + " \"" + " 님의 사용 가능 카드";
				Ctxt1 = new Text(600,110,ctxt1);
				Ctxt1.setFont(Font.font("monospace", FontWeight.BOLD, FontPosture.ITALIC, 20));
				getChildren().add(Ctxt1);
			};
			Timeline Nameani = new Timeline(new KeyFrame(Duration.millis(1000), eventHandler));
			Nameani.setCycleCount(Timeline.INDEFINITE);
			Nameani.play();
			
			ctxt2 = "현재 보유 금액 : " + Money + " 원" + "\n\n\n충전 금액을 선택하세요";
			Ctxt2 = new Text(600,160,ctxt2);
			Ctxt2.setFont(Font.font("monospace", FontWeight.BOLD, FontPosture.ITALIC, 20));
			getChildren().add(Ctxt2);
			
			Button Mbtn1 = new Button("  5000원 충전  ");
			Button Mbtn2 = new Button("  10000원 충전  ");
			Button Mbtn3 = new Button("  15000원 충전  ");
			Button Mbtn4 = new Button("  20000원 충전  ");
			Button Mbtn5 = new Button("  30000원 충전  ");
			Button Mbtn6 = new Button("  50000원 충전  ");
			Button Mbtn7 = new Button("카드 사용하기");
			Cdbtn = new Button("사용 종료");
			
			HBox btBox = new HBox();
			btBox.setLayoutX(550);
			btBox.setLayoutY(250);
			btBox.setMargin(Mbtn1, new Insets(10,30,10,30));
			btBox.setMargin(Mbtn2, new Insets(10,10,10,10));
			btBox.getChildren().addAll(Mbtn1,Mbtn2);
			
			HBox btBox1 = new HBox();
			btBox1.setLayoutX(550);
			btBox1.setLayoutY(290);
			btBox1.setMargin(Mbtn3, new Insets(10,30,10,30));
			btBox1.setMargin(Mbtn4, new Insets(10,10,10,10));
			btBox1.getChildren().addAll(Mbtn3,Mbtn4);
			
			HBox btBox2 = new HBox();
			btBox2.setLayoutX(550);
			btBox2.setLayoutY(330);
			btBox2.setMargin(Mbtn5, new Insets(10,30,10,30));
			btBox2.setMargin(Mbtn6, new Insets(10,10,10,10));
			btBox2.getChildren().addAll(Mbtn5,Mbtn6);
			
			Mbtn7.setLayoutX(680);
			Mbtn7.setLayoutY(380);
			
			Cdbtn.setLayoutX(690);
			Cdbtn.setLayoutY(420);
			
			getChildren().addAll(btBox,btBox1,btBox2,Mbtn7,Cdbtn);
			
			
			Mbtn1.setOnAction(e -> { getChildren().remove(Ctxt2); this.Money+=5000; 
				ctxt2 = "현재 보유 금액 : " + Money + " 원" + "\n\n\n충전 금액을 선택하세요";
				Ctxt2 = new Text(600,160,ctxt2);
				Ctxt2.setFont(Font.font("monospace", FontWeight.BOLD, FontPosture.ITALIC, 20));
				getChildren().add(Ctxt2);});
			
			Mbtn2.setOnAction(e -> { getChildren().remove(Ctxt2); this.Money+=10000; 
			ctxt2 = "현재 보유 금액 : " + Money + " 원" + "\n\n\n충전 금액을 선택하세요";
			Ctxt2 = new Text(600,160,ctxt2);
			Ctxt2.setFont(Font.font("monospace", FontWeight.BOLD, FontPosture.ITALIC, 20));
			getChildren().add(Ctxt2); });
			
			Mbtn3.setOnAction(e -> { getChildren().remove(Ctxt2); this.Money+=15000; 
			ctxt2 = "현재 보유 금액 : " + Money + " 원" + "\n\n\n충전 금액을 선택하세요";
			Ctxt2 = new Text(600,160,ctxt2);
			Ctxt2.setFont(Font.font("monospace", FontWeight.BOLD, FontPosture.ITALIC, 20));
			getChildren().add(Ctxt2); });
			
			Mbtn4.setOnAction(e -> { getChildren().remove(Ctxt2); this.Money+=20000; 
			ctxt2 = "현재 보유 금액 : " + Money + " 원" + "\n\n\n충전 금액을 선택하세요";
			Ctxt2 = new Text(600,160,ctxt2);
			Ctxt2.setFont(Font.font("monospace", FontWeight.BOLD, FontPosture.ITALIC, 20));
			getChildren().add(Ctxt2); });
			
			Mbtn5.setOnAction(e -> { getChildren().remove(Ctxt2); this.Money+=30000; 
			ctxt2 = "현재 보유 금액 : " + Money + " 원" + "\n\n\n충전 금액을 선택하세요";
			Ctxt2 = new Text(600,160,ctxt2);
			Ctxt2.setFont(Font.font("monospace", FontWeight.BOLD, FontPosture.ITALIC, 20));
			getChildren().add(Ctxt2); });
			
			Mbtn6.setOnAction(e -> {getChildren().remove(Ctxt2); this.Money+=50000; 
			ctxt2 = "현재 보유 금액 : " + Money + " 원" + "\n\n\n충전 금액을 선택하세요";
			Ctxt2 = new Text(600,160,ctxt2);
			Ctxt2.setFont(Font.font("monospace", FontWeight.BOLD, FontPosture.ITALIC, 20));
			getChildren().add(Ctxt2); });
			
			Mbtn7.setOnAction(e -> {
			if(Money>=1250) {
				Rectangle Bg = new Rectangle(70,70,460,310);
				Bg.setStrokeWidth(50);
				Bg.setStroke(Color.SKYBLUE);
				Bg.setFill(Color.color(0, 0, 0, 0));
				Bg.setArcWidth(10);
				Bg.setArcHeight(10);
				getChildren().add(Bg);
				
				FadeTransition ft3 = new FadeTransition(Duration.millis(2000),Bg);
				ft3.setFromValue(0.7);
				ft3.setToValue(0.0);
				ft3.setCycleCount(1);
				ft3.play();
				
				getChildren().remove(Ctxt2); this.Money-=1250; 
				ctxt2 = "현재 보유 금액 : " + Money + " 원" + "\n\n\n충전 금액을 선택하세요";
				Ctxt2 = new Text(600,160,ctxt2);
				Ctxt2.setFont(Font.font("monospace", FontWeight.BOLD, FontPosture.ITALIC, 20));
				getChildren().add(Ctxt2); }});
			
		}
	}

	
}