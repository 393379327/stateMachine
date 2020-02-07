package com.example.myapplication;

import com.github.oxo42.stateless4j.StateMachine;
import com.github.oxo42.stateless4j.StateMachineConfig;

public class NavStateMachineManager {

    static StateMachine mStateMachine;
    static  StateMachineConfig<NavState, NavStateTrigger> navStateConfig;

    public static void init() {

        navStateConfig = new StateMachineConfig<>();


        //===========电梯状态机 start===================
        navStateConfig.configure(NavState.IDLE)
                .permit(NavStateTrigger.ELEVATOR_OUTSIDE_WAITING,NavState.ELEVATOR_OUTSIDE_WAITING)
                .ignore(NavStateTrigger.IDLE)
                .ignore(NavStateTrigger.NAVIGATE_ELEVATOR_MOVING_IN)
                .ignore(NavStateTrigger.CHARGING)
                .ignore(NavStateTrigger.BUILD_MAP)
                .ignore(NavStateTrigger.UPLOAD_MAP)
                .ignore(NavStateTrigger.LOAD_MAP)
                .ignore(NavStateTrigger.LOCALIZATION)
                .ignore(NavStateTrigger.NAVIGATE_NORMAL)
                .ignore(NavStateTrigger.NAVIGATE_ELEVATOR_INSIDE)
                .ignore(NavStateTrigger.NAVIGATE_ELEVATOR_MOVING_OUT)
                .ignore(NavStateTrigger.NAVIGATE_ROLLBACK)
                .ignore(NavStateTrigger.NAVIGATE_GATE)
                .ignore(NavStateTrigger.NAVIGATE_AUTO_DOOR)
                .ignore(NavStateTrigger.NAVIGATE_MAGNETIC)
                .ignore(NavStateTrigger.ELEVATOR_INSIDE_WAITING);



        navStateConfig.configure(NavState.ELEVATOR_OUTSIDE_WAITING)
                .permit(NavStateTrigger.NAVIGATE_ELEVATOR_MOVING_IN,NavState.NAVIGATE_ELEVATOR_MOVING_IN)
                .ignore(NavStateTrigger.IDLE)
                .ignore(NavStateTrigger.CHARGING)
                .ignore(NavStateTrigger.BUILD_MAP)
                .ignore(NavStateTrigger.UPLOAD_MAP)
                .ignore(NavStateTrigger.LOAD_MAP)
                .ignore(NavStateTrigger.LOCALIZATION)
                .ignore(NavStateTrigger.NAVIGATE_NORMAL)
                .ignore(NavStateTrigger.NAVIGATE_ELEVATOR_INSIDE)
                .ignore(NavStateTrigger.NAVIGATE_ELEVATOR_MOVING_OUT)
                .ignore(NavStateTrigger.NAVIGATE_ROLLBACK)
                .ignore(NavStateTrigger.NAVIGATE_GATE)
                .ignore(NavStateTrigger.NAVIGATE_AUTO_DOOR)
                .ignore(NavStateTrigger.NAVIGATE_MAGNETIC)
                .ignore(NavStateTrigger.ELEVATOR_OUTSIDE_WAITING)
                .ignore(NavStateTrigger.ELEVATOR_INSIDE_WAITING);



        navStateConfig.configure(NavState.NAVIGATE_ELEVATOR_MOVING_IN)
                .permit(NavStateTrigger.NAVIGATE_ROLLBACK, NavState.NAVIGATE_ROLLBACK)
                .permit(NavStateTrigger.CHARGING, NavState.CHARGING)
                .permit(NavStateTrigger.NAVIGATE_ELEVATOR_INSIDE, NavState.NAVIGATE_ELEVATOR_INSIDE)
                .ignore(NavStateTrigger.IDLE)
                .ignore(NavStateTrigger.BUILD_MAP)
                .ignore(NavStateTrigger.UPLOAD_MAP)
                .ignore(NavStateTrigger.LOAD_MAP)
                .ignore(NavStateTrigger.LOCALIZATION)
                .ignore(NavStateTrigger.NAVIGATE_NORMAL)
                .ignore(NavStateTrigger.NAVIGATE_ELEVATOR_MOVING_IN)
                .ignore(NavStateTrigger.NAVIGATE_ELEVATOR_MOVING_OUT)
                .ignore(NavStateTrigger.NAVIGATE_GATE)
                .ignore(NavStateTrigger.NAVIGATE_AUTO_DOOR)
                .ignore(NavStateTrigger.NAVIGATE_MAGNETIC)
                .ignore(NavStateTrigger.ELEVATOR_INSIDE_WAITING)
                .ignore(NavStateTrigger.ELEVATOR_OUTSIDE_WAITING);



        navStateConfig.configure(NavState.NAVIGATE_ROLLBACK)
                .permit(NavStateTrigger.ELEVATOR_OUTSIDE_WAITING,NavState.ELEVATOR_OUTSIDE_WAITING)
                .permit(NavStateTrigger.CHARGING,NavState.CHARGING)
                .ignore(NavStateTrigger.IDLE)
                .ignore(NavStateTrigger.BUILD_MAP)
                .ignore(NavStateTrigger.UPLOAD_MAP)
                .ignore(NavStateTrigger.LOAD_MAP)
                .ignore(NavStateTrigger.LOCALIZATION)
                .ignore(NavStateTrigger.NAVIGATE_NORMAL)
                .ignore(NavStateTrigger.NAVIGATE_ELEVATOR_MOVING_IN)
                .ignore(NavStateTrigger.NAVIGATE_ELEVATOR_INSIDE)
                .ignore(NavStateTrigger.NAVIGATE_ELEVATOR_MOVING_OUT)
                .ignore(NavStateTrigger.NAVIGATE_ROLLBACK)
                .ignore(NavStateTrigger.NAVIGATE_GATE)
                .ignore(NavStateTrigger.NAVIGATE_AUTO_DOOR)
                .ignore(NavStateTrigger.NAVIGATE_MAGNETIC)
                .ignore(NavStateTrigger.ELEVATOR_INSIDE_WAITING);



        navStateConfig.configure(NavState.NAVIGATE_ELEVATOR_INSIDE)
                .permit(NavStateTrigger.ELEVATOR_INSIDE_WAITING,NavState.ELEVATOR_INTSIDE_WAITING)
                .permit(NavStateTrigger.CHARGING,NavState.CHARGING)
                .ignore(NavStateTrigger.IDLE)
                .ignore(NavStateTrigger.BUILD_MAP)
                .ignore(NavStateTrigger.UPLOAD_MAP)
                .ignore(NavStateTrigger.LOAD_MAP)
                .ignore(NavStateTrigger.LOCALIZATION)
                .ignore(NavStateTrigger.NAVIGATE_NORMAL)
                .ignore(NavStateTrigger.NAVIGATE_ELEVATOR_MOVING_IN)
                .ignore(NavStateTrigger.NAVIGATE_ELEVATOR_INSIDE)
                .ignore(NavStateTrigger.NAVIGATE_ELEVATOR_MOVING_OUT)
                .ignore(NavStateTrigger.NAVIGATE_ROLLBACK)
                .ignore(NavStateTrigger.NAVIGATE_GATE)
                .ignore(NavStateTrigger.NAVIGATE_AUTO_DOOR)
                .ignore(NavStateTrigger.NAVIGATE_MAGNETIC)
                .ignore(NavStateTrigger.ELEVATOR_OUTSIDE_WAITING);

        navStateConfig.configure(NavState.ELEVATOR_INTSIDE_WAITING)
                .permit(NavStateTrigger.NAVIGATE_ELEVATOR_MOVING_OUT,NavState.NAVIGATE_ELEVATOR_MOVING_OUT)
                .ignore(NavStateTrigger.IDLE)
                .ignore(NavStateTrigger.CHARGING)
                .ignore(NavStateTrigger.BUILD_MAP)
                .ignore(NavStateTrigger.UPLOAD_MAP)
                .ignore(NavStateTrigger.LOAD_MAP)
                .ignore(NavStateTrigger.LOCALIZATION)
                .ignore(NavStateTrigger.NAVIGATE_NORMAL)
                .ignore(NavStateTrigger.NAVIGATE_ELEVATOR_MOVING_IN)
                .ignore(NavStateTrigger.NAVIGATE_ELEVATOR_INSIDE)
                .ignore(NavStateTrigger.NAVIGATE_ROLLBACK)
                .ignore(NavStateTrigger.NAVIGATE_GATE)
                .ignore(NavStateTrigger.NAVIGATE_AUTO_DOOR)
                .ignore(NavStateTrigger.NAVIGATE_MAGNETIC)
                .ignore(NavStateTrigger.ELEVATOR_INSIDE_WAITING)
                .ignore(NavStateTrigger.ELEVATOR_OUTSIDE_WAITING);


        navStateConfig.configure(NavState.NAVIGATE_ELEVATOR_MOVING_OUT)
                .permit(NavStateTrigger.NAVIGATE_NORMAL, NavState.NAVIGATE_NORMAL)
                .permit(NavStateTrigger.CHARGING, NavState.CHARGING)
                .permit(NavStateTrigger.IDLE, NavState.IDLE)
                .ignore(NavStateTrigger.BUILD_MAP)
                .ignore(NavStateTrigger.UPLOAD_MAP)
                .ignore(NavStateTrigger.LOAD_MAP)
                .ignore(NavStateTrigger.LOCALIZATION)
                .ignore(NavStateTrigger.NAVIGATE_ELEVATOR_MOVING_IN)
                .ignore(NavStateTrigger.NAVIGATE_ELEVATOR_INSIDE)
                .ignore(NavStateTrigger.NAVIGATE_ELEVATOR_MOVING_OUT)
                .ignore(NavStateTrigger.NAVIGATE_ROLLBACK)
                .ignore(NavStateTrigger.NAVIGATE_GATE)
                .ignore(NavStateTrigger.NAVIGATE_AUTO_DOOR)
                .ignore(NavStateTrigger.NAVIGATE_MAGNETIC)
                .ignore(NavStateTrigger.ELEVATOR_INSIDE_WAITING)
                .ignore(NavStateTrigger.ELEVATOR_OUTSIDE_WAITING);



        //===========电梯状态机 end===================



        navStateConfig.configure(NavState.NAVIGATE_NORMAL)
                .permit(NavStateTrigger.NAVIGATE_GATE, NavState.NAVIGATE_GATE)
                .permit(NavStateTrigger.NAVIGATE_AUTO_DOOR, NavState.NAVIGATE_AUTO_DOOR)
                .permit(NavStateTrigger.CHARGING, NavState.CHARGING)
                .permit(NavStateTrigger.NAVIGATE_MAGNETIC, NavState.NAVIGATE_MAGNETIC)
                .ignore(NavStateTrigger.IDLE)
                .ignore(NavStateTrigger.BUILD_MAP)
                .ignore(NavStateTrigger.UPLOAD_MAP)
                .ignore(NavStateTrigger.LOAD_MAP)
                .ignore(NavStateTrigger.LOCALIZATION)
                .ignore(NavStateTrigger.NAVIGATE_NORMAL)
                .ignore(NavStateTrigger.NAVIGATE_ELEVATOR_MOVING_IN)
                .ignore(NavStateTrigger.NAVIGATE_ELEVATOR_INSIDE)
                .ignore(NavStateTrigger.NAVIGATE_ELEVATOR_MOVING_OUT)
                .ignore(NavStateTrigger.NAVIGATE_ROLLBACK);

        navStateConfig.configure(NavState.NAVIGATE_GATE)
                .permit(NavStateTrigger.NAVIGATE_NORMAL, NavState.NAVIGATE_NORMAL)
                .permit(NavStateTrigger.CHARGING, NavState.CHARGING)
                .ignore(NavStateTrigger.IDLE)
                .ignore(NavStateTrigger.BUILD_MAP)
                .ignore(NavStateTrigger.UPLOAD_MAP)
                .ignore(NavStateTrigger.LOAD_MAP)
                .ignore(NavStateTrigger.LOCALIZATION)
                .ignore(NavStateTrigger.NAVIGATE_ELEVATOR_MOVING_IN)
                .ignore(NavStateTrigger.NAVIGATE_ELEVATOR_INSIDE)
                .ignore(NavStateTrigger.NAVIGATE_ELEVATOR_MOVING_OUT)
                .ignore(NavStateTrigger.NAVIGATE_ROLLBACK)
                .ignore(NavStateTrigger.NAVIGATE_GATE)
                .ignore(NavStateTrigger.NAVIGATE_AUTO_DOOR)
                .ignore(NavStateTrigger.NAVIGATE_MAGNETIC);



        navStateConfig.configure(NavState.NAVIGATE_ROLLBACK)
                .permit(NavStateTrigger.IDLE, NavState.IDLE)
                .permit(NavStateTrigger.CHARGING, NavState.CHARGING)
                .ignore(NavStateTrigger.BUILD_MAP)
                .ignore(NavStateTrigger.UPLOAD_MAP)
                .ignore(NavStateTrigger.LOAD_MAP)
                .ignore(NavStateTrigger.LOCALIZATION)
                .ignore(NavStateTrigger.NAVIGATE_NORMAL)
                .ignore(NavStateTrigger.NAVIGATE_ELEVATOR_MOVING_IN)
                .ignore(NavStateTrigger.NAVIGATE_ELEVATOR_INSIDE)
                .ignore(NavStateTrigger.NAVIGATE_ELEVATOR_MOVING_OUT)
                .ignore(NavStateTrigger.NAVIGATE_ROLLBACK)
                .ignore(NavStateTrigger.NAVIGATE_GATE)
                .ignore(NavStateTrigger.NAVIGATE_AUTO_DOOR)
                .ignore(NavStateTrigger.NAVIGATE_MAGNETIC);

        navStateConfig.configure(NavState.NAVIGATE_AUTO_DOOR)
                .permit(NavStateTrigger.NAVIGATE_NORMAL, NavState.NAVIGATE_NORMAL)
                .permit(NavStateTrigger.CHARGING, NavState.CHARGING)
                .ignore(NavStateTrigger.IDLE)
                .ignore(NavStateTrigger.BUILD_MAP)
                .ignore(NavStateTrigger.UPLOAD_MAP)
                .ignore(NavStateTrigger.LOAD_MAP)
                .ignore(NavStateTrigger.LOCALIZATION)
                .ignore(NavStateTrigger.NAVIGATE_ELEVATOR_MOVING_IN)
                .ignore(NavStateTrigger.NAVIGATE_ELEVATOR_INSIDE)
                .ignore(NavStateTrigger.NAVIGATE_ELEVATOR_MOVING_OUT)
                .ignore(NavStateTrigger.NAVIGATE_ROLLBACK)
                .ignore(NavStateTrigger.NAVIGATE_GATE)
                .ignore(NavStateTrigger.NAVIGATE_AUTO_DOOR)
                .ignore(NavStateTrigger.NAVIGATE_MAGNETIC);

        navStateConfig.configure(NavState.NAVIGATE_MAGNETIC)
                .permit(NavStateTrigger.CHARGING, NavState.CHARGING)
                .ignore(NavStateTrigger.IDLE)
                .ignore(NavStateTrigger.BUILD_MAP)
                .ignore(NavStateTrigger.UPLOAD_MAP)
                .ignore(NavStateTrigger.LOAD_MAP)
                .ignore(NavStateTrigger.LOCALIZATION)
                .ignore(NavStateTrigger.NAVIGATE_NORMAL)
                .ignore(NavStateTrigger.NAVIGATE_ELEVATOR_MOVING_IN)
                .ignore(NavStateTrigger.NAVIGATE_ELEVATOR_INSIDE)
                .ignore(NavStateTrigger.NAVIGATE_ELEVATOR_MOVING_OUT)
                .ignore(NavStateTrigger.NAVIGATE_ROLLBACK)
                .ignore(NavStateTrigger.NAVIGATE_GATE)
                .ignore(NavStateTrigger.NAVIGATE_AUTO_DOOR)
                .ignore(NavStateTrigger.NAVIGATE_MAGNETIC);

        navStateConfig.configure(NavState.BUILD_MAP)
                .permit(NavStateTrigger.CHARGING, NavState.CHARGING)
                .permit(NavStateTrigger.UPLOAD_MAP, NavState.UPLOAD_MAP)
                .ignore(NavStateTrigger.IDLE)
                .ignore(NavStateTrigger.BUILD_MAP)
                .ignore(NavStateTrigger.LOAD_MAP)
                .ignore(NavStateTrigger.LOCALIZATION)
                .ignore(NavStateTrigger.NAVIGATE_NORMAL)
                .ignore(NavStateTrigger.NAVIGATE_ELEVATOR_MOVING_IN)
                .ignore(NavStateTrigger.NAVIGATE_ELEVATOR_INSIDE)
                .ignore(NavStateTrigger.NAVIGATE_ELEVATOR_MOVING_OUT)
                .ignore(NavStateTrigger.NAVIGATE_ROLLBACK)
                .ignore(NavStateTrigger.NAVIGATE_GATE)
                .ignore(NavStateTrigger.NAVIGATE_AUTO_DOOR)
                .ignore(NavStateTrigger.NAVIGATE_MAGNETIC);

        navStateConfig.configure(NavState.UPLOAD_MAP)
                .permit(NavStateTrigger.CHARGING, NavState.CHARGING)
                .permit(NavStateTrigger.IDLE, NavState.IDLE)
                .ignore(NavStateTrigger.BUILD_MAP)
                .ignore(NavStateTrigger.UPLOAD_MAP)
                .ignore(NavStateTrigger.LOAD_MAP)
                .ignore(NavStateTrigger.LOCALIZATION)
                .ignore(NavStateTrigger.NAVIGATE_NORMAL)
                .ignore(NavStateTrigger.NAVIGATE_ELEVATOR_MOVING_IN)
                .ignore(NavStateTrigger.NAVIGATE_ELEVATOR_INSIDE)
                .ignore(NavStateTrigger.NAVIGATE_ELEVATOR_MOVING_OUT)
                .ignore(NavStateTrigger.NAVIGATE_ROLLBACK)
                .ignore(NavStateTrigger.NAVIGATE_GATE)
                .ignore(NavStateTrigger.NAVIGATE_AUTO_DOOR)
                .ignore(NavStateTrigger.NAVIGATE_MAGNETIC);

        mStateMachine = new com.github.oxo42.stateless4j.StateMachine<>(NavState.IDLE,
                navStateConfig);

    }


    public static NavState getCurState() {
        return (NavState) mStateMachine.getState();
    }

    public static void switchState(NavStateTrigger trigger) {
        mStateMachine.fire(trigger);
    }


    public static void reset() {
        mStateMachine = new com.github.oxo42.stateless4j.StateMachine<>(NavState.IDLE,
                navStateConfig);
    }


    public enum NavState {
        IDLE,
        CHARGING,
        BUILD_MAP,
        UPLOAD_MAP,
        LOAD_MAP,
        LOCALIZATION,
        NAVIGATE_NORMAL,
        NAVIGATE_ELEVATOR_MOVING_IN,
        NAVIGATE_ELEVATOR_INSIDE,
        NAVIGATE_ELEVATOR_MOVING_OUT,
        NAVIGATE_ROLLBACK,
        NAVIGATE_GATE,
        NAVIGATE_AUTO_DOOR,
        NAVIGATE_MAGNETIC,
        ELEVATOR_OUTSIDE_WAITING,
        ELEVATOR_INTSIDE_WAITING
    }

    public enum NavStateTrigger {
        IDLE,
        CHARGING,
        BUILD_MAP,
        UPLOAD_MAP,
        LOAD_MAP,
        LOCALIZATION,
        NAVIGATE_NORMAL,
        NAVIGATE_ELEVATOR_MOVING_IN,
        NAVIGATE_ELEVATOR_INSIDE,
        NAVIGATE_ELEVATOR_MOVING_OUT,
        NAVIGATE_ROLLBACK,
        NAVIGATE_GATE,
        NAVIGATE_AUTO_DOOR,
        NAVIGATE_MAGNETIC,
        ELEVATOR_OUTSIDE_WAITING,
        ELEVATOR_INSIDE_WAITING
    }

}
