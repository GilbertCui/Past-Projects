import java.util.Random;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;

public class Random_Building extends Application
{
    public void start(Stage primaryStage)
    {
        Random RD = new Random();
        
        int h;
        int w;
        int shape;
        
        shape = RD.nextInt(3);
        h = RD.nextInt(200)+100;
        w = RD.nextInt(140)+160;
        
        Polygon polygon = new Polygon();
        polygon.getPoints().addAll(new Double[]{170.0, (400.0-h)-0.3*h, 170.0-0.5*w, 400.0-h, 170.0+0.5*w, 400.0-h});
        polygon.setFill(Color.SIENNA);
        
        Ellipse top = new Ellipse(170, 400-h, 0.5*w, 0.3*h);
        top.setFill(Color.SIENNA);

        Rectangle body = new Rectangle(170-0.5*w, 400-h, w, h);
        body.setFill(Color.PERU);
        
        Rectangle door = new Rectangle(170-0.5*0.2*w, 400-0.4*h, 0.2*w, 0.4*h);
        door.setFill(Color.DARKRED);
       
        Rectangle window1 = new Rectangle(170-0.4*w, (400-h)+0.3*h, 0.25*w, 0.3*h);
        window1.setFill(Color.LIGHTYELLOW);
        Rectangle window1f = new Rectangle(170-0.4*w, (400-h)+0.3*h, 0.25*w, 0.3*h);
        window1f.setStroke(Color.BLACK);
        window1f.setStrokeWidth(5);
        window1f.setFill(null);
        Rectangle window2 = new Rectangle(170+0.15*w, (400-h)+0.3*h, 0.25*w, 0.3*h);
        window2.setFill(Color.LIGHTYELLOW);
        Rectangle window2f = new Rectangle(170+0.15*w, (400-h)+0.3*h, 0.25*w, 0.3*h);
        window2f.setStroke(Color.BLACK);
        window2f.setStrokeWidth(5);
        window2f.setFill(null);
        
        Rectangle chimney = new Rectangle(170+0.2*w, (400-h)-0.33*h, 0.2*w, 0.33*h);
        chimney.setFill(Color.DARKGREY);
        Rectangle chimney2 = new Rectangle(170+0.2*w, (400-h)-0.2*h, 0.2*w, 0.2*h);
        chimney2.setFill(Color.DARKGREY);
        
        Circle doornob = new Circle(170+0.07*w, (400-0.4*h)+0.5*0.4*h, 5);
        doornob.setFill(Color.ORANGE);
       
        Line wf1 = new Line(170-0.4*w, (400-h)+0.3*h+0.15*h, 170-0.15*w, (400-h)+0.3*h+0.15*h);
        wf1.setStrokeWidth(5);
        wf1.setStroke(Color.BLACK);
        Line wf2 = new Line(170-0.275*w, (400-h)+0.3*h, 170-0.275*w, (400-h)+0.3*h+0.3*h);
        wf2.setStrokeWidth(5);
        wf2.setStroke(Color.BLACK);
        Line wf3 = new Line(170+0.15*w, (400-h)+0.3*h+0.15*h, 170+0.4*w, (400-h)+0.3*h+0.15*h);
        wf3.setStrokeWidth(5);
        wf3.setStroke(Color.BLACK);
        Line wf4 = new Line(170+0.275*w, (400-h)+0.3*h, 170+0.275*w, (400-h)+0.3*h+0.3*h);
        wf4.setStrokeWidth(5);
        wf4.setStroke(Color.BLACK);
        
        Group house = new Group(body, door, doornob, window1, window2, window1f, window2f, wf1, wf2, wf3, wf4);
        
        int hS;
        int wS;
        int shapeS;
        
        shapeS = RD.nextInt(3);
        hS = RD.nextInt(200)+100;
        wS = RD.nextInt(140)+160;
        
        Polygon polygonS = new Polygon();
        polygonS.getPoints().addAll(new Double[]{510.0, (400.0-hS)-0.3*hS, 510.0-0.5*wS, 400.0-hS, 510.0+0.5*wS, 400.0-hS});
        polygonS.setFill(Color.DARKSLATEBLUE);
        
        Ellipse topS = new Ellipse(510, 400-hS, 0.5*wS, 0.3*hS);
        topS.setFill(Color.DARKSLATEBLUE);

        Rectangle bodyS = new Rectangle(510-0.5*wS, 400-hS, wS, hS);
        bodyS.setFill(Color.CORNFLOWERBLUE);
        
        Rectangle doorS = new Rectangle(510-0.5*0.2*wS, 400-0.4*hS, 0.2*wS, 0.4*hS);
        doorS.setFill(Color.MOCCASIN);
        
        Rectangle window1S = new Rectangle(510-0.4*wS, (400-hS)+0.3*hS, 0.25*wS, 0.3*hS); 
        window1S.setFill(Color.LIGHTYELLOW);
        Rectangle window1fS = new Rectangle(510-0.4*wS, (400-hS)+0.3*hS, 0.25*wS, 0.3*hS);
        window1fS.setStroke(Color.LIGHTGREY);
        window1fS.setStrokeWidth(5);
        window1fS.setFill(null);
        Rectangle window2S = new Rectangle(510+0.15*wS, (400-hS)+0.3*hS, 0.25*wS, 0.3*hS);
        window2S.setFill(Color.LIGHTYELLOW);
        Rectangle window2fS = new Rectangle(510+0.15*wS, (400-hS)+0.3*hS, 0.25*wS, 0.3*hS);
        window2fS.setStroke(Color.LIGHTGREY);
        window2fS.setStrokeWidth(5);
        window2fS.setFill(null);
        
        Rectangle chimneyS = new Rectangle(510+0.2*wS, (400-hS)-0.33*hS, 0.2*wS, 0.33*hS);
        chimneyS.setFill(Color.NAVY);
        Rectangle chimney2S = new Rectangle(510+0.2*wS, (400-hS)-0.2*hS, 0.2*wS, 0.2*hS);
        chimney2S.setFill(Color.NAVY);
        
        Circle doornobS = new Circle(510+0.07*wS, (400-0.4*hS)+0.5*0.4*hS, 5);
        doornobS.setFill(Color.DARKKHAKI);
       
        Line wf1S = new Line(510-0.4*wS, (400-hS)+0.3*hS+0.15*hS, 510-0.15*wS, (400-hS)+0.3*hS+0.15*hS);
        wf1S.setStrokeWidth(5);
        wf1S.setStroke(Color.LIGHTGREY);
        Line wf2S = new Line(510-0.275*wS, (400-hS)+0.3*hS, 510-0.275*wS, (400-hS)+0.3*hS+0.3*hS);
        wf2S.setStrokeWidth(5);
        wf2S.setStroke(Color.LIGHTGREY);
        Line wf3S = new Line(510+0.15*wS, (400-hS)+0.3*hS+0.15*hS, 510+0.4*wS, (400-hS)+0.3*hS+0.15*hS);
        wf3S.setStrokeWidth(5);
        wf3S.setStroke(Color.LIGHTGREY);
        Line wf4S = new Line(510+0.275*wS, (400-hS)+0.3*hS, 510+0.275*wS, (400-hS)+0.3*hS+0.3*hS);
        wf4S.setStrokeWidth(5);
        wf4S.setStroke(Color.LIGHTGREY);
        
        Group houseS = new Group(bodyS, doorS, doornobS, window1S, window2S, window1fS, window2fS, wf1S, wf2S, wf3S, wf4S);

        int hT;
        int wT;
        int shapeT;
        
        shapeT = RD.nextInt(3);
        hT = RD.nextInt(200)+100;
        wT = RD.nextInt(140)+160;
        
        Polygon polygonT = new Polygon();
        polygonT.getPoints().addAll(new Double[]{850.0, (400.0-hT)-0.3*hT, 850.0-0.5*wT, 400.0-hT, 850.0+0.5*wT, 400.0-hT});
        polygonT.setFill(Color.DARKCYAN);
        
        Ellipse topT = new Ellipse(850, 400-hT, 0.5*wT, 0.3*hT);
        topT.setFill(Color.DARKCYAN);

        Rectangle bodyT = new Rectangle(850-0.5*wT, 400-hT, wT, hT);
        bodyT.setFill(Color.INDIANRED);
        
        Rectangle doorT = new Rectangle(850-0.5*0.2*wT, 400-0.4*hT, 0.2*wT, 0.4*hT);
        doorT.setFill(Color.BLACK);
       
        Rectangle window1T = new Rectangle(850-0.4*wT, (400-hT)+0.3*hT, 0.25*wT, 0.3*hT);
        window1T.setFill(Color.LIGHTYELLOW);
        Rectangle window1fT = new Rectangle(850-0.4*wT, (400-hT)+0.3*hT, 0.25*wT, 0.3*hT);
        window1fT.setStroke(Color.BLACK);
        window1fT.setStrokeWidth(5);
        window1fT.setFill(null);
        Rectangle window2T = new Rectangle(850+0.15*wT, (400-hT)+0.3*hT, 0.25*wT, 0.3*hT);
        window2T.setFill(Color.LIGHTYELLOW);
        Rectangle window2fT = new Rectangle(850+0.15*wT, (400-hT)+0.3*hT, 0.25*wT, 0.3*hT);
        window2fT.setStroke(Color.BLACK);
        window2fT.setStrokeWidth(5);
        window2fT.setFill(null);
        
        Rectangle chimneyT = new Rectangle(850+0.2*wT, (400-hT)-0.33*hT, 0.2*wT, 0.33*hT);
        chimneyT.setFill(Color.DARKSLATEGREY);
        Rectangle chimney2T = new Rectangle(850+0.2*wT, (400-hT)-0.2*hT, 0.2*wT, 0.2*hT);
        chimney2T.setFill(Color.DARKSLATEGREY);
        
        Circle doornobT = new Circle(850+0.07*wT, (400-0.4*hT)+0.5*0.4*hT, 5);
        doornobT.setFill(Color.SILVER);
       
        Line wf1T = new Line(850-0.4*wT, (400-hT)+0.3*hT+0.15*hT, 850-0.15*wT, (400-hT)+0.3*hT+0.15*hT);
        wf1T.setStrokeWidth(5);
        wf1T.setStroke(Color.BLACK);
        Line wf2T = new Line(850-0.275*wT, (400-hT)+0.3*hT, 850-0.275*wT, (400-hT)+0.3*hT+0.3*hT);
        wf2T.setStrokeWidth(5);
        wf2T.setStroke(Color.BLACK);
        Line wf3T = new Line(850+0.15*wT, (400-hT)+0.3*hT+0.15*hT, 850+0.4*wT, (400-hT)+0.3*hT+0.15*hT);
        wf3T.setStrokeWidth(5);
        wf3T.setStroke(Color.BLACK);
        Line wf4T = new Line(850+0.275*wT, (400-hT)+0.3*hT, 850+0.275*wT, (400-hT)+0.3*hT+0.3*hT);
        wf4T.setStrokeWidth(5);
        wf4T.setStroke(Color.BLACK);
        
        Group houseT = new Group(bodyT, doorT, doornobT, window1T, window2T, window1fT, window2fT, wf1T, wf2T, wf3T, wf4T);

        int hF;
        int wF;
        int shapeF;
        
        shapeF = RD.nextInt(3);
        hF = RD.nextInt(200)+100;
        wF = RD.nextInt(140)+160;
        
        Polygon polygonF = new Polygon();
        polygonF.getPoints().addAll(new Double[]{1190.0, (400.0-hF)-0.3*hF, 1190.0-0.5*wF, 400.0-hF, 1190.0+0.5*wF, 400.0-hF});
        polygonF.setFill(Color.LIGHTSLATEGREY);
        
        Ellipse topF = new Ellipse(1190, 400-hF, 0.5*wF, 0.3*hF);
        topF.setFill(Color.LIGHTSLATEGREY);

        Rectangle bodyF = new Rectangle(1190-0.5*wF, 400-hF, wF, hF);
        bodyF.setFill(Color.WHEAT);
        
        Rectangle doorF = new Rectangle(1190-0.5*0.2*wF, 400-0.4*hF, 0.2*wF, 0.4*hF);
        doorF.setFill(Color.BURLYWOOD);
       
        Rectangle window1F = new Rectangle(1190-0.4*wF, (400-hF)+0.3*hF, 0.25*wF, 0.3*hF);
        window1F.setFill(Color.LIGHTYELLOW);
        Rectangle window1fF = new Rectangle(1190-0.4*wF, (400-hF)+0.3*hF, 0.25*wF, 0.3*hF);
        window1fF.setStroke(Color.SADDLEBROWN);
        window1fF.setStrokeWidth(5);
        window1fF.setFill(null);
        Rectangle window2F = new Rectangle(1190+0.15*wF, (400-hF)+0.3*hF, 0.25*wF, 0.3*hF);
        window2F.setFill(Color.LIGHTYELLOW);
        Rectangle window2fF = new Rectangle(1190+0.15*wF, (400-hF)+0.3*hF, 0.25*wF, 0.3*hF);
        window2fF.setStroke(Color.SADDLEBROWN);
        window2fF.setStrokeWidth(5);
        window2fF.setFill(null);
        
        Rectangle chimneyF = new Rectangle(1190+0.2*wF, (400-hF)-0.33*hF, 0.2*wF, 0.33*hF);
        chimneyF.setFill(Color.MAROON);
        Rectangle chimney2F = new Rectangle(1190+0.2*wF, (400-hF)-0.2*hF, 0.2*wF, 0.2*hF);
        chimney2F.setFill(Color.MAROON);
        
        Circle doornobF = new Circle(1190+0.07*wF, (400-0.4*hF)+0.5*0.4*hF, 5);
        doornobF.setFill(Color.GOLD);
       
        Line wf1F = new Line(1190-0.4*wF, (400-hF)+0.3*hF+0.15*hF, 1190-0.15*wF, (400-hF)+0.3*hF+0.15*hF);
        wf1F.setStrokeWidth(5);
        wf1F.setStroke(Color.SADDLEBROWN);
        Line wf2F = new Line(1190-0.275*wF, (400-hF)+0.3*hF, 1190-0.275*wF, (400-hF)+0.3*hF+0.3*hF);
        wf2F.setStrokeWidth(5);
        wf2F.setStroke(Color.SADDLEBROWN);
        Line wf3F = new Line(1190+0.15*wF, (400-hF)+0.3*hF+0.15*hF, 1190+0.4*wF, (400-hF)+0.3*hF+0.15*hF);
        wf3F.setStrokeWidth(5);
        wf3F.setStroke(Color.SADDLEBROWN);
        Line wf4F = new Line(1190+0.275*wF, (400-hF)+0.3*hF, 1190+0.275*wF, (400-hF)+0.3*hF+0.3*hF);
        wf4F.setStrokeWidth(5);
        wf4F.setStroke(Color.SADDLEBROWN);
        
        Group houseF = new Group(bodyF, doorF, doornobF, window1F, window2F, window1fF, window2fF, wf1F, wf2F, wf3F, wf4F);

        Rectangle ground0 = new Rectangle(0, 400, 1360, 100);
        ground0.setFill(Color.DIMGREY);
        
        Line yellowline1 = new Line(0, 445, 1360, 445);
        yellowline1.setStroke(Color.YELLOW);
        yellowline1.setStrokeWidth(2);
        Line yellowline2 = new Line(0, 455, 1360, 455);
        yellowline2.setStroke(Color.YELLOW);
        yellowline2.setStrokeWidth(2);
        
        Group ground = new Group(ground0, yellowline1, yellowline2);
        
        if (shape <= 0)
        {
            Group HOUSE = new Group(chimney, polygon, house);
            if (shapeS <= 0)
            {
                Group HOUSEs = new Group(chimneyS, polygonS, houseS);
                if (shapeT <= 0)
                {
                    Group HOUSEt = new Group(chimneyT, polygonT, houseT);
                    if (shapeF <= 0)
                    {
                        Group HOUSEf = new Group(chimneyF, polygonF, houseF);
                        Group root = new Group(ground, HOUSE, HOUSEs, HOUSEt,HOUSEf);
                        Scene scene = new Scene(root, 1360, 500, Color.LIGHTBLUE);
                        primaryStage.setScene(scene);
                    }
                    else if (shapeF <= 1)
                    {
                        Group HOUSEf = new Group(chimneyF, topF, houseF);
                        Group root = new Group(ground, HOUSE, HOUSEs, HOUSEt,HOUSEf);
                        Scene scene = new Scene(root, 1360, 500, Color.LIGHTBLUE);
                        primaryStage.setScene(scene);
                    }
                    else if (shapeF <= 2)
                    {
                        Group HOUSEf = new Group(chimney2F, houseF);
                        Group root = new Group(ground, HOUSE, HOUSEs, HOUSEt,HOUSEf);
                        Scene scene = new Scene(root, 1360, 500, Color.LIGHTBLUE);
                        primaryStage.setScene(scene);
                    }
                }
                else if (shapeT <= 1)
                {
                    Group HOUSEt = new Group(chimneyT, topT, houseT);
                    if (shapeF <= 0)
                    {
                        Group HOUSEf = new Group(chimneyF, polygonF, houseF);
                        Group root = new Group(ground, HOUSE, HOUSEs, HOUSEt,HOUSEf);
                        Scene scene = new Scene(root, 1360, 500, Color.LIGHTBLUE);
                        primaryStage.setScene(scene);
                    }
                    else if (shapeF <= 1)
                    {
                        Group HOUSEf = new Group(chimneyF, topF, houseF);
                        Group root = new Group(ground, HOUSE, HOUSEs, HOUSEt,HOUSEf);
                        Scene scene = new Scene(root, 1360, 500, Color.LIGHTBLUE);
                        primaryStage.setScene(scene);
                    }
                    else if (shapeF <= 2)
                    {
                        Group HOUSEf = new Group(chimney2F, houseF);
                        Group root = new Group(ground, HOUSE, HOUSEs, HOUSEt,HOUSEf);
                        Scene scene = new Scene(root, 1360, 500, Color.LIGHTBLUE);
                        primaryStage.setScene(scene);
                    }
                }
                else if (shapeT <= 2)
                {
                    Group HOUSEt = new Group(chimney2T, houseT);
                    if (shapeF <= 0)
                    {
                        Group HOUSEf = new Group(chimneyF, polygonF, houseF);
                        Group root = new Group(ground, HOUSE, HOUSEs, HOUSEt,HOUSEf);
                        Scene scene = new Scene(root, 1360, 500, Color.LIGHTBLUE);
                        primaryStage.setScene(scene);
                    }
                   else if (shapeF <= 1)
                    {
                        Group HOUSEf = new Group(chimneyF, topF, houseF);
                        Group root = new Group(ground, HOUSE, HOUSEs, HOUSEt,HOUSEf);
                        Scene scene = new Scene(root, 1360, 500, Color.LIGHTBLUE);
                        primaryStage.setScene(scene);
                    }
                    else if (shapeF <= 2)
                    {
                        Group HOUSEf = new Group(chimney2F, houseF);
                        Group root = new Group(ground, HOUSE, HOUSEs, HOUSEt,HOUSEf);
                        Scene scene = new Scene(root, 1360, 500, Color.LIGHTBLUE);
                        primaryStage.setScene(scene);
                    }
                }
            }
            else if (shapeS <= 1)
            {
                Group HOUSEs = new Group(chimneyS, topS, houseS);
                if (shapeT <= 0)
                {
                    Group HOUSEt = new Group(chimneyT, polygonT, houseT);
                    if (shapeF <= 0)
                    {
                        Group HOUSEf = new Group(chimneyF, polygonF, houseF);
                        Group root = new Group(ground, HOUSE, HOUSEs, HOUSEt,HOUSEf);
                        Scene scene = new Scene(root, 1360, 500, Color.LIGHTBLUE);
                        primaryStage.setScene(scene);
                    }
                   else if (shapeF <= 1)
                    {
                        Group HOUSEf = new Group(chimneyF, topF, houseF);
                        Group root = new Group(ground, HOUSE, HOUSEs, HOUSEt,HOUSEf);
                        Scene scene = new Scene(root, 1360, 500, Color.LIGHTBLUE);
                        primaryStage.setScene(scene);
                    }
                    else if (shapeF <= 2)
                    {
                        Group HOUSEf = new Group(chimney2F, houseF);
                        Group root = new Group(ground, HOUSE, HOUSEs, HOUSEt,HOUSEf);
                        Scene scene = new Scene(root, 1360, 500, Color.LIGHTBLUE);
                        primaryStage.setScene(scene);
                    }
                }
                else if (shapeT <= 1)
                {
                    Group HOUSEt = new Group(chimneyT, topT, houseT);
                    if (shapeF <= 0)
                    {
                        Group HOUSEf = new Group(chimneyF, polygonF, houseF);
                        Group root = new Group(ground, HOUSE, HOUSEs, HOUSEt,HOUSEf);
                        Scene scene = new Scene(root, 1360, 500, Color.LIGHTBLUE);
                        primaryStage.setScene(scene);
                    }
                    else if (shapeF <= 1)
                    {
                        Group HOUSEf = new Group(chimneyF, topF, houseF);
                        Group root = new Group(ground, HOUSE, HOUSEs, HOUSEt,HOUSEf);
                        Scene scene = new Scene(root, 1360, 500, Color.LIGHTBLUE);
                        primaryStage.setScene(scene);
                    }
                    else if (shapeF <= 2)
                    {
                        Group HOUSEf = new Group(chimney2F, houseF);
                        Group root = new Group(ground, HOUSE, HOUSEs, HOUSEt,HOUSEf);
                        Scene scene = new Scene(root, 1360, 500, Color.LIGHTBLUE);
                        primaryStage.setScene(scene);
                    }
                }
                else if (shapeT <= 2)
                {
                    Group HOUSEt = new Group(chimney2T, houseT);
                    if (shapeF <= 0)
                    {
                        Group HOUSEf = new Group(chimneyF, polygonF, houseF);
                        Group root = new Group(ground, HOUSE, HOUSEs, HOUSEt,HOUSEf);
                        Scene scene = new Scene(root, 1360, 500, Color.LIGHTBLUE);
                        primaryStage.setScene(scene);
                    }
                    else if (shapeF <= 1)
                    {
                        Group HOUSEf = new Group(chimneyF, topF, houseF);
                        Group root = new Group(ground, HOUSE, HOUSEs, HOUSEt,HOUSEf);
                        Scene scene = new Scene(root, 1360, 500, Color.LIGHTBLUE);
                        primaryStage.setScene(scene);
                    }
                    else if (shapeF <= 2)
                    {
                        Group HOUSEf = new Group(chimney2F, houseF);
                        Group root = new Group(ground, HOUSE, HOUSEs, HOUSEt,HOUSEf);
                        Scene scene = new Scene(root, 1360, 500, Color.LIGHTBLUE);
                        primaryStage.setScene(scene);
                    }
                }
            }
            else if (shapeS <= 2)
            {
                Group HOUSEs = new Group(chimney2S, houseS);
                if (shapeT <= 0)
                {
                    Group HOUSEt = new Group(chimneyT, polygonT, houseT);
                    if (shapeF <= 0)
                    {
                        Group HOUSEf = new Group(chimneyF, polygonF, houseF);
                        Group root = new Group(ground, HOUSE, HOUSEs, HOUSEt,HOUSEf);
                        Scene scene = new Scene(root, 1360, 500, Color.LIGHTBLUE);
                        primaryStage.setScene(scene);
                    }
                   else if (shapeF <= 1)
                    {
                        Group HOUSEf = new Group(chimneyF, topF, houseF);
                        Group root = new Group(ground, HOUSE, HOUSEs, HOUSEt,HOUSEf);
                        Scene scene = new Scene(root, 1360, 500, Color.LIGHTBLUE);
                        primaryStage.setScene(scene);
                    }
                    else if (shapeF <= 2)
                    {
                        Group HOUSEf = new Group(chimney2F, houseF);
                        Group root = new Group(ground, HOUSE, HOUSEs, HOUSEt,HOUSEf);
                        Scene scene = new Scene(root, 1360, 500, Color.LIGHTBLUE);
                        primaryStage.setScene(scene);
                    }
                }
                else if (shapeT <= 1)
                {
                    Group HOUSEt = new Group(chimneyT, topT, houseT);
                    if (shapeF <= 0)
                    {
                        Group HOUSEf = new Group(chimneyF, polygonF, houseF);
                        Group root = new Group(ground, HOUSE, HOUSEs, HOUSEt,HOUSEf);
                        Scene scene = new Scene(root, 1360, 500, Color.LIGHTBLUE);
                        primaryStage.setScene(scene);
                    }
                    else if (shapeF <= 1)
                    {
                        Group HOUSEf = new Group(chimneyF, topF, houseF);
                        Group root = new Group(ground, HOUSE, HOUSEs, HOUSEt,HOUSEf);
                        Scene scene = new Scene(root, 1360, 500, Color.LIGHTBLUE);
                        primaryStage.setScene(scene);
                    }
                    else if (shapeF <= 2)
                    {
                        Group HOUSEf = new Group(chimney2F, houseF);
                        Group root = new Group(ground, HOUSE, HOUSEs, HOUSEt,HOUSEf);
                        Scene scene = new Scene(root, 1360, 500, Color.LIGHTBLUE);
                        primaryStage.setScene(scene);
                    }
                }
                else if (shapeT <= 2)
                {
                    Group HOUSEt = new Group(chimney2T, houseT);
                    if (shapeF <= 0)
                    {
                        Group HOUSEf = new Group(chimneyF, polygonF, houseF);
                        Group root = new Group(ground, HOUSE, HOUSEs, HOUSEt,HOUSEf);
                        Scene scene = new Scene(root, 1360, 500, Color.LIGHTBLUE);
                        primaryStage.setScene(scene);
                    }
                    else if (shapeF <= 1)
                    {
                        Group HOUSEf = new Group(chimneyF, topF, houseF);
                        Group root = new Group(ground, HOUSE, HOUSEs, HOUSEt,HOUSEf);
                        Scene scene = new Scene(root, 1360, 500, Color.LIGHTBLUE);
                        primaryStage.setScene(scene);
                    }
                    else if (shapeF <= 2)
                    {
                        Group HOUSEf = new Group(chimney2F, houseF);
                        Group root = new Group(ground, HOUSE, HOUSEs, HOUSEt,HOUSEf);
                        Scene scene = new Scene(root, 1360, 500, Color.LIGHTBLUE);
                        primaryStage.setScene(scene);
                    }
                }
            }
        }
        else if(shape <= 1)
        {
            Group HOUSE = new Group(chimney, top, house);
            if (shapeS <= 0)
            {
                Group HOUSEs = new Group(chimneyS, polygonS, houseS);
                if (shapeT <= 0)
                {
                    Group HOUSEt = new Group(chimneyT, polygonT, houseT);
                    if (shapeF <= 0)
                    {
                        Group HOUSEf = new Group(chimneyF, polygonF, houseF);
                        Group root = new Group(ground, HOUSE, HOUSEs, HOUSEt,HOUSEf);
                        Scene scene = new Scene(root, 1360, 500, Color.LIGHTBLUE);
                        primaryStage.setScene(scene);
                    }
                    else if (shapeF <= 1)
                    {
                        Group HOUSEf = new Group(chimneyF, topF, houseF);
                        Group root = new Group(ground, HOUSE, HOUSEs, HOUSEt,HOUSEf);
                        Scene scene = new Scene(root, 1360, 500, Color.LIGHTBLUE);
                        primaryStage.setScene(scene);
                    }
                    else if (shapeF <= 2)
                    {
                        Group HOUSEf = new Group(chimney2F, houseF);
                        Group root = new Group(ground, HOUSE, HOUSEs, HOUSEt,HOUSEf);
                        Scene scene = new Scene(root, 1360, 500, Color.LIGHTBLUE);
                        primaryStage.setScene(scene);
                    }
                }
                else if (shapeT <= 1)
                {
                    Group HOUSEt = new Group(chimneyT, topT, houseT);
                    if (shapeF <= 0)
                    {
                        Group HOUSEf = new Group(chimneyF, polygonF, houseF);
                        Group root = new Group(ground, HOUSE, HOUSEs, HOUSEt,HOUSEf);
                        Scene scene = new Scene(root, 1360, 500, Color.LIGHTBLUE);
                        primaryStage.setScene(scene);
                    }
                    else if (shapeF <= 1)
                    {
                        Group HOUSEf = new Group(chimneyF, topF, houseF);
                        Group root = new Group(ground, HOUSE, HOUSEs, HOUSEt,HOUSEf);
                        Scene scene = new Scene(root, 1360, 500, Color.LIGHTBLUE);
                        primaryStage.setScene(scene);
                    }
                    else if (shapeF <= 2)
                    {
                        Group HOUSEf = new Group(chimney2F, houseF);
                        Group root = new Group(ground, HOUSE, HOUSEs, HOUSEt,HOUSEf);
                        Scene scene = new Scene(root, 1360, 500, Color.LIGHTBLUE);
                        primaryStage.setScene(scene);
                    }
                }
                else if (shapeT <= 2)
                {
                    Group HOUSEt = new Group(chimney2T, houseT);
                    if (shapeF <= 0)
                    {
                        Group HOUSEf = new Group(chimneyF, polygonF, houseF);
                        Group root = new Group(ground, HOUSE, HOUSEs, HOUSEt,HOUSEf);
                        Scene scene = new Scene(root, 1360, 500, Color.LIGHTBLUE);
                        primaryStage.setScene(scene);
                    }
                    else if (shapeF <= 1)
                    {
                        Group HOUSEf = new Group(chimneyF, topF, houseF);
                        Group root = new Group(ground, HOUSE, HOUSEs, HOUSEt,HOUSEf);
                        Scene scene = new Scene(root, 1360, 500, Color.LIGHTBLUE);
                        primaryStage.setScene(scene);
                    }
                    else if (shapeF <= 2)
                    {
                        Group HOUSEf = new Group(chimney2F, houseF);
                        Group root = new Group(ground, HOUSE, HOUSEs, HOUSEt,HOUSEf);
                        Scene scene = new Scene(root, 1360, 500, Color.LIGHTBLUE);
                        primaryStage.setScene(scene);
                    }
                }
            }
            else if (shapeS <= 1)
            {
                Group HOUSEs = new Group(chimneyS, topS, houseS);
                if (shapeT <= 0)
                {
                    Group HOUSEt = new Group(chimneyT, polygonT, houseT);
                    if (shapeF <= 0)
                    {
                        Group HOUSEf = new Group(chimneyF, polygonF, houseF);
                        Group root = new Group(ground, HOUSE, HOUSEs, HOUSEt,HOUSEf);
                        Scene scene = new Scene(root, 1360, 500, Color.LIGHTBLUE);
                        primaryStage.setScene(scene);
                    }
                    else if (shapeF <= 1)
                    {
                        Group HOUSEf = new Group(chimneyF, topF, houseF);
                        Group root = new Group(ground, HOUSE, HOUSEs, HOUSEt,HOUSEf);
                        Scene scene = new Scene(root, 1360, 500, Color.LIGHTBLUE);
                        primaryStage.setScene(scene);
                    }
                    else if (shapeF <= 2)
                    {
                        Group HOUSEf = new Group(chimney2F, houseF);
                        Group root = new Group(ground, HOUSE, HOUSEs, HOUSEt,HOUSEf);
                        Scene scene = new Scene(root, 1360, 500, Color.LIGHTBLUE);
                        primaryStage.setScene(scene);
                    }
                }
                else if (shapeT <= 1)
                {
                    Group HOUSEt = new Group(chimneyT, topT, houseT);
                    if (shapeF <= 0)
                    {
                        Group HOUSEf = new Group(chimneyF, polygonF, houseF);
                        Group root = new Group(ground, HOUSE, HOUSEs, HOUSEt,HOUSEf);
                        Scene scene = new Scene(root, 1360, 500, Color.LIGHTBLUE);
                        primaryStage.setScene(scene);
                    }
                    else if (shapeF <= 1)
                    {
                        Group HOUSEf = new Group(chimneyF, topF, houseF);
                        Group root = new Group(ground, HOUSE, HOUSEs, HOUSEt,HOUSEf);
                        Scene scene = new Scene(root, 1360, 500, Color.LIGHTBLUE);
                        primaryStage.setScene(scene);
                    }
                    else if (shapeF <= 2)
                    {
                        Group HOUSEf = new Group(chimney2F, houseF);
                        Group root = new Group(ground, HOUSE, HOUSEs, HOUSEt,HOUSEf);
                        Scene scene = new Scene(root, 1360, 500, Color.LIGHTBLUE);
                        primaryStage.setScene(scene);
                    }
                }
                else if (shapeT <= 2)
                {
                    Group HOUSEt = new Group(chimney2T, houseT);
                    if (shapeF <= 0)
                    {
                        Group HOUSEf = new Group(chimneyF, polygonF, houseF);
                        Group root = new Group(ground, HOUSE, HOUSEs, HOUSEt,HOUSEf);
                        Scene scene = new Scene(root, 1360, 500, Color.LIGHTBLUE);
                        primaryStage.setScene(scene);
                    }
                    else if (shapeF <= 1)
                    {
                        Group HOUSEf = new Group(chimneyF, topF, houseF);
                        Group root = new Group(ground, HOUSE, HOUSEs, HOUSEt,HOUSEf);
                        Scene scene = new Scene(root, 1360, 500, Color.LIGHTBLUE);
                        primaryStage.setScene(scene);
                    }
                    else if (shapeF <= 2)
                    {
                        Group HOUSEf = new Group(chimney2F, houseF);
                        Group root = new Group(ground, HOUSE, HOUSEs, HOUSEt,HOUSEf);
                        Scene scene = new Scene(root, 1360, 500, Color.LIGHTBLUE);
                        primaryStage.setScene(scene);
                    }
                }
            }
            else if (shapeS <= 2)
            {
                Group HOUSEs = new Group(chimney2S, houseS);
                if (shapeT <= 0)
                {
                    Group HOUSEt = new Group(chimneyT, polygonT, houseT);
                    if (shapeF <= 0)
                    {
                        Group HOUSEf = new Group(chimneyF, polygonF, houseF);
                        Group root = new Group(ground, HOUSE, HOUSEs, HOUSEt,HOUSEf);
                        Scene scene = new Scene(root, 1360, 500, Color.LIGHTBLUE);
                        primaryStage.setScene(scene);
                    }
                    else if (shapeF <= 1)
                    {
                        Group HOUSEf = new Group(chimneyF, topF, houseF);
                        Group root = new Group(ground, HOUSE, HOUSEs, HOUSEt,HOUSEf);
                        Scene scene = new Scene(root, 1360, 500, Color.LIGHTBLUE);
                        primaryStage.setScene(scene);
                    }
                    else if (shapeF <= 2)
                    {
                        Group HOUSEf = new Group(chimney2F, houseF);
                        Group root = new Group(ground, HOUSE, HOUSEs, HOUSEt,HOUSEf);
                        Scene scene = new Scene(root, 1360, 500, Color.LIGHTBLUE);
                        primaryStage.setScene(scene);
                    }
                }
                else if (shapeT <= 1)
                {
                    Group HOUSEt = new Group(chimneyT, topT, houseT);
                    if (shapeF <= 0)
                    {
                        Group HOUSEf = new Group(chimneyF, polygonF, houseF);
                        Group root = new Group(ground, HOUSE, HOUSEs, HOUSEt,HOUSEf);
                        Scene scene = new Scene(root, 1360, 500, Color.LIGHTBLUE);
                        primaryStage.setScene(scene);
                    }
                    else if (shapeF <= 1)
                    {
                        Group HOUSEf = new Group(chimneyF, topF, houseF);
                        Group root = new Group(ground, HOUSE, HOUSEs, HOUSEt,HOUSEf);
                        Scene scene = new Scene(root, 1360, 500, Color.LIGHTBLUE);
                        primaryStage.setScene(scene);
                    }
                    else if (shapeF <= 2)
                    {
                        Group HOUSEf = new Group(chimney2F, houseF);
                        Group root = new Group(ground, HOUSE, HOUSEs, HOUSEt,HOUSEf);
                        Scene scene = new Scene(root, 1360, 500, Color.LIGHTBLUE);
                        primaryStage.setScene(scene);
                    }
                }
                else if (shapeT <= 2)
                {
                    Group HOUSEt = new Group(chimney2T, houseT);
                    if (shapeF <= 0)
                    {
                        Group HOUSEf = new Group(chimneyF, polygonF, houseF);
                        Group root = new Group(ground, HOUSE, HOUSEs, HOUSEt,HOUSEf);
                        Scene scene = new Scene(root, 1360, 500, Color.LIGHTBLUE);
                        primaryStage.setScene(scene);
                    }
                    else if (shapeF <= 1)
                    {
                        Group HOUSEf = new Group(chimneyF, topF, houseF);
                        Group root = new Group(ground, HOUSE, HOUSEs, HOUSEt,HOUSEf);
                        Scene scene = new Scene(root, 1360, 500, Color.LIGHTBLUE);
                        primaryStage.setScene(scene);
                    }
                    else if (shapeF <= 2)
                    {
                        Group HOUSEf = new Group(chimney2F, houseF);
                        Group root = new Group(ground, HOUSE, HOUSEs, HOUSEt,HOUSEf);
                        Scene scene = new Scene(root, 1360, 500, Color.LIGHTBLUE);
                        primaryStage.setScene(scene);
                    }
                }
            }
        }
        else if(shape <= 2)
        {
            Group HOUSE = new Group(chimney2, house);
            if (shapeS <= 0)
            {
                Group HOUSEs = new Group(chimneyS, polygonS, houseS);
                if (shapeT <= 0)
                {
                    Group HOUSEt = new Group(chimneyT, polygonT, houseT);
                    if (shapeF <= 0)
                    {
                        Group HOUSEf = new Group(chimneyF, polygonF, houseF);
                        Group root = new Group(ground, HOUSE, HOUSEs, HOUSEt,HOUSEf);
                        Scene scene = new Scene(root, 1360, 500, Color.LIGHTBLUE);
                        primaryStage.setScene(scene);
                    }
                    else if (shapeF <= 1)
                    {
                        Group HOUSEf = new Group(chimneyF, topF, houseF);
                        Group root = new Group(ground, HOUSE, HOUSEs, HOUSEt,HOUSEf);
                        Scene scene = new Scene(root, 1360, 500, Color.LIGHTBLUE);
                        primaryStage.setScene(scene);
                    }
                    else if (shapeF <= 2)
                    {
                        Group HOUSEf = new Group(chimney2F, houseF);
                        Group root = new Group(ground, HOUSE, HOUSEs, HOUSEt,HOUSEf);
                        Scene scene = new Scene(root, 1360, 500, Color.LIGHTBLUE);
                        primaryStage.setScene(scene);
                    }
                }
                else if (shapeT <= 1)
                {
                    Group HOUSEt = new Group(chimneyT, topT, houseT);
                    if (shapeF <= 0)
                    {
                        Group HOUSEf = new Group(chimneyF, polygonF, houseF);
                        Group root = new Group(ground, HOUSE, HOUSEs, HOUSEt,HOUSEf);
                        Scene scene = new Scene(root, 1360, 500, Color.LIGHTBLUE);
                        primaryStage.setScene(scene);
                    }
                    else if (shapeF <= 1)
                    {
                        Group HOUSEf = new Group(chimneyF, topF, houseF);
                        Group root = new Group(ground, HOUSE, HOUSEs, HOUSEt,HOUSEf);
                        Scene scene = new Scene(root, 1360, 500, Color.LIGHTBLUE);
                        primaryStage.setScene(scene);
                    }
                    else if (shapeF <= 2)
                    {
                        Group HOUSEf = new Group(chimney2F, houseF);
                        Group root = new Group(ground, HOUSE, HOUSEs, HOUSEt,HOUSEf);
                        Scene scene = new Scene(root, 1360, 500, Color.LIGHTBLUE);
                        primaryStage.setScene(scene);
                    }
                }
                else if (shapeT <= 2)
                {
                    Group HOUSEt = new Group(chimney2T, houseT);
                    if (shapeF <= 0)
                    {
                        Group HOUSEf = new Group(chimneyF, polygonF, houseF);
                        Group root = new Group(ground, HOUSE, HOUSEs, HOUSEt,HOUSEf);
                        Scene scene = new Scene(root, 1360, 500, Color.LIGHTBLUE);
                        primaryStage.setScene(scene);
                    }
                    else if (shapeF <= 1)
                    {
                        Group HOUSEf = new Group(chimneyF, topF, houseF);
                        Group root = new Group(ground, HOUSE, HOUSEs, HOUSEt,HOUSEf);
                        Scene scene = new Scene(root, 1360, 500, Color.LIGHTBLUE);
                        primaryStage.setScene(scene);
                    }
                    else if (shapeF <= 2)
                    {
                        Group HOUSEf = new Group(chimney2F, houseF);
                        Group root = new Group(ground, HOUSE, HOUSEs, HOUSEt,HOUSEf);
                        Scene scene = new Scene(root, 1360, 500, Color.LIGHTBLUE);
                        primaryStage.setScene(scene);
                    }
                }
            }
            else if (shapeS <= 1)
            {
                Group HOUSEs = new Group(chimneyS, topS, houseS);
                if (shapeT <= 0)
                {
                    Group HOUSEt = new Group(chimneyT, polygonT, houseT);
                    if (shapeF <= 0)
                    {
                        Group HOUSEf = new Group(chimneyF, polygonF, houseF);
                        Group root = new Group(ground, HOUSE, HOUSEs, HOUSEt,HOUSEf);
                        Scene scene = new Scene(root, 1360, 500, Color.LIGHTBLUE);
                        primaryStage.setScene(scene);
                    }
                    else if (shapeF <= 1)
                    {
                        Group HOUSEf = new Group(chimneyF, topF, houseF);
                        Group root = new Group(ground, HOUSE, HOUSEs, HOUSEt,HOUSEf);
                        Scene scene = new Scene(root, 1360, 500, Color.LIGHTBLUE);
                        primaryStage.setScene(scene);
                    }
                    else if (shapeF <= 2)
                    {
                        Group HOUSEf = new Group(chimney2F, houseF);
                        Group root = new Group(ground, HOUSE, HOUSEs, HOUSEt,HOUSEf);
                        Scene scene = new Scene(root, 1360, 500, Color.LIGHTBLUE);
                        primaryStage.setScene(scene);
                    }
                }
                else if (shapeT <= 1)
                {
                    Group HOUSEt = new Group(chimneyT, topT, houseT);
                    if (shapeF <= 0)
                    {
                        Group HOUSEf = new Group(chimneyF, polygonF, houseF);
                        Group root = new Group(ground, HOUSE, HOUSEs, HOUSEt,HOUSEf);
                        Scene scene = new Scene(root, 1360, 500, Color.LIGHTBLUE);
                        primaryStage.setScene(scene);
                    }
                    else if (shapeF <= 1)
                    {
                        Group HOUSEf = new Group(chimneyF, topF, houseF);
                        Group root = new Group(ground, HOUSE, HOUSEs, HOUSEt,HOUSEf);
                        Scene scene = new Scene(root, 1360, 500, Color.LIGHTBLUE);
                        primaryStage.setScene(scene);
                    }
                    else if (shapeF <= 2)
                    {
                        Group HOUSEf = new Group(chimney2F, houseF);
                        Group root = new Group(ground, HOUSE, HOUSEs, HOUSEt,HOUSEf);
                        Scene scene = new Scene(root, 1360, 500, Color.LIGHTBLUE);
                        primaryStage.setScene(scene);
                    }
                }
                else if (shapeT <= 2)
                {
                    Group HOUSEt = new Group(chimney2T, houseT);
                    if (shapeF <= 0)
                    {
                        Group HOUSEf = new Group(chimneyF, polygonF, houseF);
                        Group root = new Group(ground, HOUSE, HOUSEs, HOUSEt,HOUSEf);
                        Scene scene = new Scene(root, 1360, 500, Color.LIGHTBLUE);
                        primaryStage.setScene(scene);
                    }
                    else if (shapeF <= 1)
                    {
                        Group HOUSEf = new Group(chimneyF, topF, houseF);
                        Group root = new Group(ground, HOUSE, HOUSEs, HOUSEt,HOUSEf);
                        Scene scene = new Scene(root, 1360, 500, Color.LIGHTBLUE);
                        primaryStage.setScene(scene);
                    }
                    else if (shapeF <= 2)
                    {
                        Group HOUSEf = new Group(chimney2F, houseF);
                        Group root = new Group(ground, HOUSE, HOUSEs, HOUSEt,HOUSEf);
                        Scene scene = new Scene(root, 1360, 500, Color.LIGHTBLUE);
                        primaryStage.setScene(scene);
                    }
                }
            }
            else if (shapeS <= 2)
            {
                Group HOUSEs = new Group(chimney2S, houseS);
                if (shapeT <= 0)
                {
                    Group HOUSEt = new Group(chimneyT, polygonT, houseT);
                    if (shapeF <= 0)
                    {
                        Group HOUSEf = new Group(chimneyF, polygonF, houseF);
                        Group root = new Group(ground, HOUSE, HOUSEs, HOUSEt,HOUSEf);
                        Scene scene = new Scene(root, 1360, 500, Color.LIGHTBLUE);
                        primaryStage.setScene(scene);
                    }
                    else if (shapeF <= 1)
                    {
                        Group HOUSEf = new Group(chimneyF, topF, houseF);
                        Group root = new Group(ground, HOUSE, HOUSEs, HOUSEt,HOUSEf);
                        Scene scene = new Scene(root, 1360, 500, Color.LIGHTBLUE);
                        primaryStage.setScene(scene);
                    }
                    else if (shapeF <= 2)
                    {
                        Group HOUSEf = new Group(chimney2F, houseF);
                        Group root = new Group(ground, HOUSE, HOUSEs, HOUSEt,HOUSEf);
                        Scene scene = new Scene(root, 1360, 500, Color.LIGHTBLUE);
                        primaryStage.setScene(scene);
                    }
                }
                else if (shapeT <= 1)
                {
                    Group HOUSEt = new Group(chimneyT, topT, houseT);
                    if (shapeF <= 0)
                    {
                        Group HOUSEf = new Group(chimneyF, polygonF, houseF);
                        Group root = new Group(ground, HOUSE, HOUSEs, HOUSEt,HOUSEf);
                        Scene scene = new Scene(root, 1360, 500, Color.LIGHTBLUE);
                        primaryStage.setScene(scene);
                    }
                    else if (shapeF <= 1)
                    {
                        Group HOUSEf = new Group(chimneyF, topF, houseF);
                        Group root = new Group(ground, HOUSE, HOUSEs, HOUSEt,HOUSEf);
                        Scene scene = new Scene(root, 1360, 500, Color.LIGHTBLUE);
                        primaryStage.setScene(scene);
                    }
                    else if (shapeF <= 2)
                    {
                        Group HOUSEf = new Group(chimney2F, houseF);
                        Group root = new Group(ground, HOUSE, HOUSEs, HOUSEt,HOUSEf);
                        Scene scene = new Scene(root, 1360, 500, Color.LIGHTBLUE);
                        primaryStage.setScene(scene);
                    }
                }
                else if (shapeT <= 2)
                {
                    Group HOUSEt = new Group(chimney2T, houseT);
                    if (shapeF <= 0)
                    {
                        Group HOUSEf = new Group(chimneyF, polygonF, houseF);
                        Group root = new Group(ground, HOUSE, HOUSEs, HOUSEt,HOUSEf);
                        Scene scene = new Scene(root, 1360, 500, Color.LIGHTBLUE);
                        primaryStage.setScene(scene);
                    }
                    else if (shapeF <= 1)
                    {
                        Group HOUSEf = new Group(chimneyF, topF, houseF);
                        Group root = new Group(ground, HOUSE, HOUSEs, HOUSEt,HOUSEf);
                        Scene scene = new Scene(root, 1360, 500, Color.LIGHTBLUE);
                        primaryStage.setScene(scene);
                    }
                    else if (shapeF <= 2)
                    {
                        Group HOUSEf = new Group(chimney2F, houseF);
                        Group root = new Group(ground, HOUSE, HOUSEs, HOUSEt,HOUSEf);
                        Scene scene = new Scene(root, 1360, 500, Color.LIGHTBLUE);
                        primaryStage.setScene(scene);
                    }
                }
            }
        }
        primaryStage.setTitle("Random Buildings");
        primaryStage.show();
    }

    public static void main(String[] args)
    {
        launch(args);
    }
}