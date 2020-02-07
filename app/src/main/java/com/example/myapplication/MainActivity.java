package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.example.myapplication.NavStateMachineManager.NavStateTrigger;

public class MainActivity extends AppCompatActivity {


    @BindView(R.id.arrive_o)
    TextView mArriveO;

    @BindView(R.id.accept_move_in)
    TextView mAcceptMoveIn;

    @BindView(R.id.arrive_aa)
    TextView mArriveA;

    @BindView(R.id.rollback)
    TextView mRollback;

    @BindView(R.id.rollback_o)
    TextView mRollbackO;

    @BindView(R.id.rollback_o_fail)
    TextView mRollbackOFail;

    @BindView(R.id.loadmap_finish)
    TextView mLoadmapFinish;

    @BindView(R.id.move_out)
    TextView mMoveOut;

    @BindView(R.id.move_out_timeout)
    TextView mMoveOutTimeout;

    @BindView(R.id.through_a)
    TextView mThroughA;

    @BindView(R.id.curState)
    TextView curState;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        NavStateMachineManager.init();

        DemoStateMachine.init();

        curState.setText("当前状态:"+NavStateMachineManager.getCurState());
    }


    @OnClick({R.id.arrive_o, R.id.accept_move_in, R.id.arrive_aa, R.id.rollback, R.id.rollback_o,
            R.id.rollback_o_fail, R.id.loadmap_finish, R.id.move_out, R.id.move_out_timeout,
            R.id.through_a,R.id.reset_Idel})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.arrive_o:
                NavStateMachineManager.switchState(NavStateTrigger.ELEVATOR_OUTSIDE_WAITING);

                break;
            case R.id.accept_move_in:
                NavStateMachineManager.switchState(NavStateTrigger.NAVIGATE_ELEVATOR_MOVING_IN);

                break;
            case R.id.arrive_aa:
                NavStateMachineManager.switchState(NavStateTrigger.NAVIGATE_ELEVATOR_INSIDE);

                break;
            case R.id.rollback:
                NavStateMachineManager.switchState(NavStateTrigger.NAVIGATE_ROLLBACK);

                break;
            case R.id.rollback_o:
                NavStateMachineManager.switchState(NavStateTrigger.ELEVATOR_OUTSIDE_WAITING);

                break;
            case R.id.rollback_o_fail:
                NavStateMachineManager.switchState(NavStateTrigger.IDLE);

                break;
            case R.id.loadmap_finish:
                NavStateMachineManager.switchState(NavStateTrigger.ELEVATOR_INSIDE_WAITING);

                break;
            case R.id.move_out:
                NavStateMachineManager.switchState(NavStateTrigger.NAVIGATE_ELEVATOR_MOVING_OUT);

                break;
            case R.id.move_out_timeout:
                NavStateMachineManager.switchState(NavStateTrigger.IDLE);

                break;
            case R.id.through_a:
                NavStateMachineManager.switchState(NavStateTrigger.NAVIGATE_NORMAL);

                break;

            case R.id.reset_Idel:
                NavStateMachineManager.reset();

                break;
        }

        curState.setText("当前状态:"+NavStateMachineManager.getCurState());
    }
}


