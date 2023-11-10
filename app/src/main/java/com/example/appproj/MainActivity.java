package com.example.appproj;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Window;

import com.example.appproj.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.settingLayout.setOnClickListener(v -> {
            startActivity(new Intent(MainActivity.this, SettingActivity.class));
        });

        binding.pwLayout.setOnClickListener(v -> {
            PWDialog pwDialog = new PWDialog(MainActivity.this);
            pwDialog.show();
        });

        binding.logoutLayout.setOnClickListener(v -> {
            LogoutDialog logoutDialog = new LogoutDialog(MainActivity.this);
            logoutDialog.show();
        });

        binding.editProfile.setOnClickListener(v -> {
            startActivity(new Intent(MainActivity.this, EditProfileActivity.class));
        });

        binding.helpLayout.setOnClickListener(v -> {
            startActivity(new Intent(MainActivity.this, HelpActivity.class));
        });


    }

    public class PWDialog extends Dialog{

        public PWDialog(@NonNull Context context) {
            super(context);
            makedialog();
        }

        private void makedialog() {
            // Dialog 생성 및 설정
            requestWindowFeature(Window.FEATURE_NO_TITLE);
            setContentView(R.layout.dialog_pw);

            // 각 위젯에 대한 이벤트 처리 등을 추가할 수 있습니다.
            AppCompatButton cancelButton = findViewById(R.id.noButton);
            AppCompatButton yesButton = findViewById(R.id.yesButton);

            cancelButton.setOnClickListener(v -> dismiss()); // 취소 버튼 클릭 시 다이얼로그 닫기
            yesButton.setOnClickListener(v -> {
                // 변경 버튼 클릭 시 수행할 작업 추가
                // 예를 들어, 비밀번호 변경 로직을 여기에 추가
                dismiss();
            });
        }
        }

    public class LogoutDialog extends Dialog {

        public LogoutDialog(@NonNull Context context) {
            super(context);
            init();
        }

        private void init() {
            // Dialog 생성 및 설정
            requestWindowFeature(Window.FEATURE_NO_TITLE);
            setContentView(R.layout.dialog_logout);

            // 각 위젯에 대한 이벤트 처리 등을 추가할 수 있습니다.
            AppCompatButton noButton = findViewById(R.id.noButton);
            AppCompatButton yesButton = findViewById(R.id.yesButton);

            noButton.setOnClickListener(v -> dismiss()); // 아니오 버튼 클릭 시 다이얼로그 닫기
            yesButton.setOnClickListener(v -> {
                // 네 버튼 클릭 시 수행할 작업 추가
                // 예를 들어, 로그아웃 로직을 여기에 추가
                dismiss();
            });
        }
    }

}