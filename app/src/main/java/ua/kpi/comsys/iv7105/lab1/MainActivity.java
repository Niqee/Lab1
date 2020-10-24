package ua.kpi.comsys.iv7105.lab1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CoordinateVD defaultCoordinate = new CoordinateVD();
        CoordinateVD coordinateVD1 = new CoordinateVD(Direction.latitudeS, 5, 5, 5);
        CoordinateVD coordinateVD2 = new CoordinateVD(Direction.latitudeS, 10, 9, 45);

        System.out.println(defaultCoordinate.getInFormatA());
        System.out.println(defaultCoordinate.getInFormatB());
        System.out.println(coordinateVD1.getInFormatA());
        System.out.println(coordinateVD1.getInFormatB());
        System.out.println(coordinateVD2.getInFormatA());
        System.out.println(coordinateVD2.getInFormatB());

        System.out.println(coordinateVD1.getBetween(coordinateVD2).getInFormatA());
        System.out.println(CoordinateVD.getBetween(coordinateVD1, coordinateVD2).getInFormatA());
    }
}