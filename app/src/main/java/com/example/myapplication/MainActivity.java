package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import com.example.myapplication.NavStateMachineManager.NavStateTrigger;
import com.github.oxo42.stateless4j.StateMachine;
import com.github.oxo42.stateless4j.StateMachineConfig;
import com.github.oxo42.stateless4j.delegates.Action;
import com.github.oxo42.stateless4j.delegates.Action1;
import com.github.oxo42.stateless4j.delegates.FuncBoolean;
import com.github.oxo42.stateless4j.transitions.Transition;
import com.github.oxo42.stateless4j.triggers.TriggerWithParameters1;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    StateMachine<State, Trigger> phoneCall;

    TriggerWithParameters1 withParameters1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //测试1
        NavStateMachineManager.init();


        //测试2
        StateMachineConfig<State, Trigger> phoneCallConfig = new StateMachineConfig<>();

        withParameters1 = phoneCallConfig.setTriggerParameters(Trigger.CallDialed, String.class);

        phoneCallConfig.configure(State.OffHook)
                .permitIf(Trigger.CallDialed, State.Ringing, new FuncBoolean() {
                    @Override
                    public boolean call() {
                        return true;
                    }
                });

        phoneCallConfig.configure(State.Ringing)
                .ignore(Trigger.CallDialed)
                .permit(Trigger.HungUp, State.OffHook)
                .permit(Trigger.CallConnected, State.Connected)
                .onEntryFrom(withParameters1, new Action1<String>() {
                    @Override
                    public void doIt(final String arg1) {
                        Toast.makeText(MainActivity.this, "ffffff" + arg1, Toast.LENGTH_LONG)
                                .show();
                    }
                });

        // this example uses Java 8 method references
        // a Java 7 example is provided in /examples
        phoneCallConfig.configure(State.Connected)
                .onEntry(new EntryAction())
                .onExit(new ExitAction())
                .permit(Trigger.LeftMessage, State.OffHook)
                .permit(Trigger.HungUp, State.OffHook)
                .permit(Trigger.PlacedOnHold, State.OnHold);

        // init
        phoneCall = new StateMachine<>(State.OffHook, phoneCallConfig);

        findViewById(R.id.test1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {

                //直接状态转换   done

                //进入当前状态，从当前状态离开的  action   done

                // 传入参数，转换的时候执行其他动作    done

                // 根据传入的参数判断是否能转换  permitIf  done

                //phoneCall.fire(Trigger.CallConnected);
                phoneCall.fire(withParameters1, "ddd");
                Toast.makeText(MainActivity.this, "测试2" + phoneCall.getState(), Toast.LENGTH_LONG)
                        .show();
                //
                //TriggerWithParameters1 twp = phoneCall.setTriggerParameters(Trigger.D, java
                // .util.Map.class);
                //sm.configure(State.D).permit(Trigger.A, State.A)
                //        .onEntryFrom( twp, new Action1<Map>(){
                //            public void doIt(Map m) {
                //                System.out.println(m.toString());
                //            }
                //        }, Map.class);
                //Map data = new HashMap();
                //data.put("a", "1");
                //sm.fire(twp, data);

            }
        });
        findViewById(R.id.test2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {

                NavStateMachineManager.switchState(NavStateTrigger.CHARGING);
                Toast.makeText(MainActivity.this, "测试2" + NavStateMachineManager.getCurState(), Toast.LENGTH_LONG)
                        .show();

            }
        });

    }


    enum Trigger {
        CallDialed, HungUp, CallConnected, LeftMessage, PlacedOnHold, TakenOffHold,
        PhoneHurledAgainstWall, MuteMicrophone, UnmuteMicrophone, SetVolume
    }

    public enum State {
        OffHook, Ringing, Connected, OnHold, PhoneDestroyed
    }


    public class EntryAction implements Action1<Transition<State, Trigger>> {
        @Override
        public void doIt(Transition<State, Trigger> arg1) {
            Toast.makeText(MainActivity.this, "EntryAction", Toast.LENGTH_LONG)
                    .show();
            System.out.println("ENTRY TO : " + arg1.getDestination());
        }
    }


    public class ExitAction implements Action1<Transition<State, Trigger>> {
        @Override
        public void doIt(Transition<State, Trigger> arg1) {
            Toast.makeText(MainActivity.this, "ExitAction", Toast.LENGTH_LONG)
                    .show();
            System.out.println("OUT FROM :" + arg1.getSource());
        }
    }

}


