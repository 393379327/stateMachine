package com.example.myapplication;

import android.util.Log;
import android.widget.Toast;
import com.github.oxo42.stateless4j.StateMachine;
import com.github.oxo42.stateless4j.StateMachineConfig;
import com.github.oxo42.stateless4j.delegates.Action1;
import com.github.oxo42.stateless4j.delegates.FuncBoolean;
import com.github.oxo42.stateless4j.transitions.Transition;
import com.github.oxo42.stateless4j.triggers.TriggerWithParameters1;

public class DemoStateMachine {


    static StateMachine<State, Trigger> phoneCall;

    static TriggerWithParameters1 withParameters1;

    public static  void init(){
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
                        Log.d("DemoStateMachine","参数"+arg1);
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
    }


    public static void switchStateWithParam(){
        phoneCall.fire(withParameters1, "ddd");
    }




    enum Trigger {
        CallDialed, HungUp, CallConnected, LeftMessage, PlacedOnHold, TakenOffHold,
        PhoneHurledAgainstWall, MuteMicrophone, UnmuteMicrophone, SetVolume
    }

    public enum State {
        OffHook, Ringing, Connected, OnHold, PhoneDestroyed
    }


    public static class EntryAction implements Action1<Transition<State, Trigger>> {
        @Override
        public void doIt(Transition<State, Trigger> arg1) {
            System.out.println("ENTRY TO : " + arg1.getDestination());
        }
    }


    public static class ExitAction implements Action1<Transition<State, Trigger>> {
        @Override
        public void doIt(Transition<State, Trigger> arg1) {

            System.out.println("OUT FROM :" + arg1.getSource());
        }
    }
}
