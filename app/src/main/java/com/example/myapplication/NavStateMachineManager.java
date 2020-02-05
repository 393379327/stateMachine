package com.example.myapplication;

import com.example.myapplication.MainActivity.State;
import com.github.oxo42.stateless4j.StateMachine;
import com.github.oxo42.stateless4j.StateMachineConfig;

public class NavStateMachineManager {

    static StateMachine mStateMachine;

    public static void init(){

        //问题1
        //wiki  上的  navigateCharge状态没有

        //问题 2      下方的问题2  注释

        //问题3   LOAD_MAP ,LOCALIZATION  这两个状态在wiki上没有定义，不确定触发条件


        StateMachineConfig<NavState, NavStateTrigger> navStateConfig = new StateMachineConfig<>();

        navStateConfig.configure(NavState.IDLE)
                .permit(NavStateTrigger.NAVIGATE_ELEVATOR_MOVING_IN,NavState.NAVIGATE_ELEVATOR_MOVING_IN)
                .permit(NavStateTrigger.NAVIGATE_ELEVATOR_MOVING_OUT,NavState.NAVIGATE_ELEVATOR_MOVING_OUT)
                .permit(NavStateTrigger.BUILD_MAP,NavState.BUILD_MAP)
                .permit(NavStateTrigger.CHARGING,NavState.CHARGING)
                .ignore(NavStateTrigger.IDLE)
                .ignore(NavStateTrigger.UPLOAD_MAP)
                .ignore(NavStateTrigger.LOAD_MAP)
                .ignore(NavStateTrigger.LOCALIZATION)
                .ignore(NavStateTrigger.NAVIGATE_NORMAL)
                .ignore(NavStateTrigger.NAVIGATE_ELEVATOR_INSIDE)
                .ignore(NavStateTrigger.NAVIGATE_ROLLBACK)
                .ignore(NavStateTrigger.NAVIGATE_GATE)
                .ignore(NavStateTrigger.NAVIGATE_AUTO_DOOR)
                .ignore(NavStateTrigger.NAVIGATE_MAGNETIC);




        //问题 2   文档上五个触发状态，  代码中navigateCharge  没有这个状态
        navStateConfig.configure(NavState.NAVIGATE_NORMAL)
                .permit(NavStateTrigger.NAVIGATE_GATE,NavState.NAVIGATE_GATE)
                .permit(NavStateTrigger.NAVIGATE_AUTO_DOOR,NavState.NAVIGATE_AUTO_DOOR)
                .permit(NavStateTrigger.CHARGING,NavState.CHARGING)
                .permit(NavStateTrigger.NAVIGATE_MAGNETIC,NavState.NAVIGATE_MAGNETIC)
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
                .permit(NavStateTrigger.NAVIGATE_NORMAL,NavState.NAVIGATE_NORMAL)
                .permit(NavStateTrigger.CHARGING,NavState.CHARGING)
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


        navStateConfig.configure(NavState.NAVIGATE_ELEVATOR_MOVING_OUT)
                .permit(NavStateTrigger.NAVIGATE_NORMAL,NavState.NAVIGATE_NORMAL)
                .permit(NavStateTrigger.CHARGING,NavState.CHARGING)
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
                .permit(NavStateTrigger.IDLE,NavState.IDLE)
                .permit(NavStateTrigger.CHARGING,NavState.CHARGING)
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


        navStateConfig.configure(NavState.NAVIGATE_ELEVATOR_MOVING_IN)
                .permit(NavStateTrigger.NAVIGATE_ROLLBACK,NavState.NAVIGATE_ROLLBACK)
                .permit(NavStateTrigger.CHARGING,NavState.CHARGING)
                .permit(NavStateTrigger.NAVIGATE_ELEVATOR_INSIDE,NavState.NAVIGATE_ELEVATOR_INSIDE)
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
                .ignore(NavStateTrigger.NAVIGATE_MAGNETIC);


        navStateConfig.configure(NavState.NAVIGATE_ELEVATOR_INSIDE)
                .permit(NavStateTrigger.IDLE,NavState.IDLE)
                .permit(NavStateTrigger.CHARGING,NavState.CHARGING)
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
                .permit(NavStateTrigger.NAVIGATE_NORMAL,NavState.NAVIGATE_NORMAL)
                .permit(NavStateTrigger.CHARGING,NavState.CHARGING)
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
                .ignore(NavStateTrigger.NAVIGATE_MAGNETIC);


        navStateConfig.configure(NavState.BUILD_MAP)
                .permit(NavStateTrigger.CHARGING,NavState.CHARGING)
                .permit(NavStateTrigger.UPLOAD_MAP,NavState.UPLOAD_MAP)
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
                .permit(NavStateTrigger.CHARGING,NavState.CHARGING)
                .permit(NavStateTrigger.IDLE,NavState.IDLE)
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






        mStateMachine = new com.github.oxo42.stateless4j.StateMachine<>(NavState.IDLE, navStateConfig);

    }


    public static NavState getCurState(){
        return (NavState) mStateMachine.getState();
    }
    public static void switchState(NavStateTrigger trigger){
        mStateMachine.fire(trigger);
    }


    public enum NavState{
        IDLE,
        CHARGING       ,
        BUILD_MAP      ,
        UPLOAD_MAP     ,
        LOAD_MAP       ,
        LOCALIZATION   ,
        NAVIGATE_NORMAL,
        NAVIGATE_ELEVATOR_MOVING_IN,
        NAVIGATE_ELEVATOR_INSIDE,
        NAVIGATE_ELEVATOR_MOVING_OUT,
        NAVIGATE_ROLLBACK,
        NAVIGATE_GATE  ,
        NAVIGATE_AUTO_DOOR,
        NAVIGATE_MAGNETIC
    }

    public enum NavStateTrigger{
        IDLE,
        CHARGING       ,
        BUILD_MAP      ,
        UPLOAD_MAP     ,
        LOAD_MAP       ,
        LOCALIZATION   ,
        NAVIGATE_NORMAL,
        NAVIGATE_ELEVATOR_MOVING_IN,
        NAVIGATE_ELEVATOR_INSIDE,
        NAVIGATE_ELEVATOR_MOVING_OUT,
        NAVIGATE_ROLLBACK,
        NAVIGATE_GATE  ,
        NAVIGATE_AUTO_DOOR,
        NAVIGATE_MAGNETIC
    }










}
