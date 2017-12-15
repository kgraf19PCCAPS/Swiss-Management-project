package saltywalty.swissmanagement;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import android.widget.ArrayAdapter;

public class MainActivity extends AppCompatActivity {
    Employee karlMarx = new Employee("Karl Marx");
    House house1 = new House("Soviet Russia");
    House house2 = new House("People's Republic of China");
    House house3 = new House("Yugoslavia");
    ArrayList<House> houses = new ArrayList();
    Spinner OOS;
    ArrayAdapter<CharSequence> OOA;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        house1.addtask(new Task("Test faucets", "Test the faucets in the master bathroom and kitchen",
                new Calendars("10/25/2017"), true, 7));
        house2.addtask(new Task("Set hot-tub temp", "Set the hot-tub on the porch to 100 degrees F",
                new Calendars("10/25/2017"), true, 7));
        karlMarx.assign(house1.tasks);
        karlMarx.assign(house2.tasks);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        houses.add(house1);
        houses.add(house2);
        houses.add(house3);

    }

    protected void employeeButtonClick(View v) {
        TextView tv = (TextView) findViewById(R.id.Text);
        String tasks = "Your Tasks:\n";
        for (House b : houses) {
            tasks += (b.address + ":\n");
            for (Task c : b.GetTasks()) {
                tasks += ("\t"+c + "\n");
            }
        }
        tv.setText(tasks);
    }
    protected void inputButtonClick(View v) {
        TextView tv = (TextView) findViewById(R.id.Text);
        setContentView(R.layout.activity_main2);
        //Ouput Options Spinner and Adapter
        OOS = (Spinner) findViewById(R.id.outputOptions);
        OOA = ArrayAdapter.createFromResource(this, R.array.input_options, android.R.layout.simple_spinner_item);
        OOA.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        OOS.setAdapter(OOA);
    }
    protected void returnButtonClick(View v) {
        setContentView(R.layout.activity_main);
    }

    protected void houseButtonClick(View v) {
        TextView tv = (TextView) findViewById(R.id.Text);
        String house = "Houses:\n";
        for (House b : houses) {
            house += (b.address + "\n");
        }
        tv.setText(house);
    }
}
