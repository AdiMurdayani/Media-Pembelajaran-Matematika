package com.adi.mediapembelajaranmatematika.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import com.adi.mediapembelajaranmatematika.R;

import io.github.kexanie.library.MathView;

public class Materi extends AppCompatActivity {

    private ImageView btn_kembali;
    private Button playBtn_1, playBtn_2, playBtn_3, playBtn_4, playBtn_5, playBtn_6, playBtn_7;
    private SeekBar positionBar_1, positionBar_2, positionBar_3, positionBar_4, positionBar_5, positionBar_6, positionBar_7;
    private TextView elapseTimeLabel_1, elapseTimeLabel_2, elapseTimeLabel_3, elapseTimeLabel_4, elapseTimeLabel_5, elapseTimeLabel_6, elapseTimeLabel_7;
    private TextView remainingTimeLabel_1, remainingTimeLabel_2, remainingTimeLabel_3, remainingTimeLabel_4, remainingTimeLabel_5, remainingTimeLabel_6, remainingTimeLabel_7;
    private MediaPlayer mp_1, mp_2, mp_3, mp_4, mp_5, mp_6, mp_7;
    private int totalTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_materi);
        init();
    }

    private void init() {

        btn_kembali = findViewById(R.id.btn_kembali);
        btn_kembali.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Materi.super.onBackPressed();
            }
        });

//        play button
        playBtn_1 = (Button) findViewById(R.id.btnplay1);
        playBtn_2 = (Button) findViewById(R.id.btnplay2);
        playBtn_3 = (Button) findViewById(R.id.btnplay3);
        playBtn_4 = (Button) findViewById(R.id.btnplay4);
        playBtn_5 = (Button) findViewById(R.id.btnplay5);
        playBtn_6 = (Button) findViewById(R.id.btnplay6);
        playBtn_7 = (Button) findViewById(R.id.btnplay7);
//        end play button

//        elapsetimelabel
        elapseTimeLabel_1 = (TextView) findViewById(R.id.elapseTimeLabel1);
        elapseTimeLabel_2 = (TextView) findViewById(R.id.elapseTimeLabel2);
        elapseTimeLabel_3 = (TextView) findViewById(R.id.elapseTimeLabel3);
        elapseTimeLabel_4 = (TextView) findViewById(R.id.elapseTimeLabel4);
        elapseTimeLabel_5 = (TextView) findViewById(R.id.elapseTimeLabel5);
        elapseTimeLabel_6 = (TextView) findViewById(R.id.elapseTimeLabel6);
        elapseTimeLabel_7 = (TextView) findViewById(R.id.elapseTimeLabel7);
//        end elapsetimelabel

//        remaining time label
        remainingTimeLabel_1 = (TextView) findViewById(R.id.remainingTimeLabel1);
        remainingTimeLabel_2 = (TextView) findViewById(R.id.remainingTimeLabel2);
        remainingTimeLabel_3 = (TextView) findViewById(R.id.remainingTimeLabel3);
        remainingTimeLabel_4 = (TextView) findViewById(R.id.remainingTimeLabel4);
        remainingTimeLabel_5 = (TextView) findViewById(R.id.remainingTimeLabel5);
        remainingTimeLabel_6 = (TextView) findViewById(R.id.remainingTimeLabel6);
        remainingTimeLabel_7 = (TextView) findViewById(R.id.remainingTimeLabel7);
//        end remaining time label

//        position bar
        positionBar_1 = (SeekBar) findViewById(R.id.positionBar1);
        positionBar_2 = (SeekBar) findViewById(R.id.positionBar2);
        positionBar_3 = (SeekBar) findViewById(R.id.positionBar3);
        positionBar_4 = (SeekBar) findViewById(R.id.positionBar4);
        positionBar_5 = (SeekBar) findViewById(R.id.positionBar5);
        positionBar_6 = (SeekBar) findViewById(R.id.positionBar6);
        positionBar_7 = (SeekBar) findViewById(R.id.positionBar7);
//        end position bar

        percakapan1();
        percakapan2();
        percakapan3();
        percakapan4();
        percakapan5();
        percakapan6();
        percakapan7();
    }

    //    percakapan 1
    private void percakapan1() {
        mp_1 = MediaPlayer.create(this, R.raw.kesamaan_dua_matriks1);
        mp_1.setLooping(false);
        mp_1.seekTo(0);
        mp_1.setVolume(0.5f, 0.5f);
        totalTime = mp_1.getDuration();

        positionBar_1.setMax(totalTime);
        positionBar_1.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if (fromUser) {
                    mp_1.seekTo(progress);
                    positionBar_1.setProgress(progress);
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (mp_1 != null) {
                    try {
                        Message msg = new Message();
                        msg.what = mp_1.getCurrentPosition();
                        handler1.sendMessage(msg);
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                    }
                }
            }
        }).start();
    }

    private Handler handler1 = new Handler() {
        @Override
        public void handleMessage(@NonNull Message msg) {
            int currentPosition = msg.what;
            positionBar_1.setProgress(currentPosition);

            String elapseTime = createTimeLabel1(currentPosition);
            elapseTimeLabel_1.setText(elapseTime);

            String remainingTime = createTimeLabel1(totalTime = currentPosition);
            remainingTimeLabel_1.setText("-" + remainingTime);
        }
    };

    public String createTimeLabel1(int time) {
        String timeLabel = "";
        int min = time / 1000 / 60;
        int sec = time / 1000 % 60;

        timeLabel = min + ":";
        if (sec < 10) timeLabel += "0";
        timeLabel += sec;

        return timeLabel;
    }

    public void playBtnClick1(View view) {
        if (!mp_1.isPlaying()) {
            mp_1.start();
            playBtn_1.setBackgroundResource(R.drawable.ic_pause);
        } else {
            mp_1.pause();
            playBtn_1.setBackgroundResource(R.drawable.ic_play);
        }
    }
//    end percakapan 1

    //    percakapan 2
    private void percakapan2() {
        mp_2 = MediaPlayer.create(this, R.raw.kesamaan_dua_matriks2);
        mp_2.setLooping(false);
        mp_2.seekTo(0);
        mp_2.setVolume(0.5f, 0.5f);
        totalTime = mp_2.getDuration();

        positionBar_2.setMax(totalTime);
        positionBar_2.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if (fromUser) {
                    mp_2.seekTo(progress);
                    positionBar_2.setProgress(progress);
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (mp_2 != null) {
                    try {
                        Message msg = new Message();
                        msg.what = mp_2.getCurrentPosition();
                        handler2.sendMessage(msg);
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                    }
                }
            }
        }).start();
    }

    private Handler handler2 = new Handler() {
        @Override
        public void handleMessage(@NonNull Message msg) {
            int currentPosition = msg.what;
            positionBar_2.setProgress(currentPosition);

            String elapseTime = createTimeLabel2(currentPosition);
            elapseTimeLabel_2.setText(elapseTime);

            String remainingTime = createTimeLabel2(totalTime = currentPosition);
            remainingTimeLabel_2.setText("-" + remainingTime);
        }
    };

    public String createTimeLabel2(int time) {
        String timeLabel = "";
        int min = time / 1000 / 60;
        int sec = time / 1000 % 60;

        timeLabel = min + ":";
        if (sec < 10) timeLabel += "0";
        timeLabel += sec;

        return timeLabel;
    }

    public void playBtnClick2(View view) {
        if (!mp_2.isPlaying()) {
            mp_2.start();
            playBtn_2.setBackgroundResource(R.drawable.ic_pause);
        } else {
            mp_2.pause();
            playBtn_2.setBackgroundResource(R.drawable.ic_play);
        }
    }
//    end percakapan 2

    //    percakapan 3
    private void percakapan3() {
        mp_3 = MediaPlayer.create(this, R.raw.operasi_penjumlahan_matriks);
        mp_3.setLooping(false);
        mp_3.seekTo(0);
        mp_3.setVolume(0.5f, 0.5f);
        totalTime = mp_3.getDuration();

        positionBar_3.setMax(totalTime);
        positionBar_3.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if (fromUser) {
                    mp_3.seekTo(progress);
                    positionBar_3.setProgress(progress);
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (mp_3 != null) {
                    try {
                        Message msg = new Message();
                        msg.what = mp_3.getCurrentPosition();
                        handler3.sendMessage(msg);
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                    }
                }
            }
        }).start();
    }

    private Handler handler3 = new Handler() {
        @Override
        public void handleMessage(@NonNull Message msg) {
            int currentPosition = msg.what;
            positionBar_3.setProgress(currentPosition);

            String elapseTime = createTimeLabel2(currentPosition);
            elapseTimeLabel_3.setText(elapseTime);

            String remainingTime = createTimeLabel3(totalTime = currentPosition);
            remainingTimeLabel_3.setText("-" + remainingTime);
        }
    };

    public String createTimeLabel3(int time) {
        String timeLabel = "";
        int min = time / 1000 / 60;
        int sec = time / 1000 % 60;

        timeLabel = min + ":";
        if (sec < 10) timeLabel += "0";
        timeLabel += sec;

        return timeLabel;
    }

    public void playBtnClick3(View view) {
        if (!mp_3.isPlaying()) {
            mp_3.start();
            playBtn_3.setBackgroundResource(R.drawable.ic_pause);
        } else {
            mp_3.pause();
            playBtn_3.setBackgroundResource(R.drawable.ic_play);
        }
    }
//    end percakapan 3

    //    percakapan 4
    private void percakapan4() {
        mp_4 = MediaPlayer.create(this, R.raw.operasi_pengurangan_matriks);
        mp_4.setLooping(false);
        mp_4.seekTo(0);
        mp_4.setVolume(0.5f, 0.5f);
        totalTime = mp_4.getDuration();

        positionBar_4.setMax(totalTime);
        positionBar_4.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if (fromUser) {
                    mp_4.seekTo(progress);
                    positionBar_4.setProgress(progress);
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (mp_4 != null) {
                    try {
                        Message msg = new Message();
                        msg.what = mp_4.getCurrentPosition();
                        handler4.sendMessage(msg);
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                    }
                }
            }
        }).start();
    }

    private Handler handler4 = new Handler() {
        @Override
        public void handleMessage(@NonNull Message msg) {
            int currentPosition = msg.what;
            positionBar_4.setProgress(currentPosition);

            String elapseTime = createTimeLabel4(currentPosition);
            elapseTimeLabel_4.setText(elapseTime);

            String remainingTime = createTimeLabel4(totalTime = currentPosition);
            remainingTimeLabel_4.setText("-" + remainingTime);
        }
    };

    public String createTimeLabel4(int time) {
        String timeLabel = "";
        int min = time / 1000 / 60;
        int sec = time / 1000 % 60;

        timeLabel = min + ":";
        if (sec < 10) timeLabel += "0";
        timeLabel += sec;

        return timeLabel;
    }

    public void playBtnClick4(View view) {
        if (!mp_4.isPlaying()) {
            mp_4.start();
            playBtn_4.setBackgroundResource(R.drawable.ic_pause);
        } else {
            mp_4.pause();
            playBtn_4.setBackgroundResource(R.drawable.ic_play);
        }
    }
//    end percakapan 4


    //    percakapan 5
    private void percakapan5() {
        mp_5 = MediaPlayer.create(this, R.raw.operasi_perkalian_skalar_pada_matriks);
        mp_5.setLooping(false);
        mp_5.seekTo(0);
        mp_5.setVolume(0.5f, 0.5f);
        totalTime = mp_5.getDuration();

        positionBar_5.setMax(totalTime);
        positionBar_5.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if (fromUser) {
                    mp_5.seekTo(progress);
                    positionBar_5.setProgress(progress);
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (mp_5 != null) {
                    try {
                        Message msg = new Message();
                        msg.what = mp_5.getCurrentPosition();
                        handler5.sendMessage(msg);
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                    }
                }
            }
        }).start();
    }

    private Handler handler5 = new Handler() {
        @Override
        public void handleMessage(@NonNull Message msg) {
            int currentPosition = msg.what;
            positionBar_5.setProgress(currentPosition);

            String elapseTime = createTimeLabel5(currentPosition);
            elapseTimeLabel_5.setText(elapseTime);

            String remainingTime = createTimeLabel5(totalTime = currentPosition);
            remainingTimeLabel_5.setText("-" + remainingTime);
        }
    };

    public String createTimeLabel5(int time) {
        String timeLabel = "";
        int min = time / 1000 / 60;
        int sec = time / 1000 % 60;

        timeLabel = min + ":";
        if (sec < 10) timeLabel += "0";
        timeLabel += sec;

        return timeLabel;
    }

    public void playBtnClick5(View view) {
        if (!mp_5.isPlaying()) {
            mp_5.start();
            playBtn_5.setBackgroundResource(R.drawable.ic_pause);
        } else {
            mp_5.pause();
            playBtn_5.setBackgroundResource(R.drawable.ic_play);
        }
    }
//    end percakapan 5


    //    percakapan 6
    private void percakapan6() {
        mp_6 = MediaPlayer.create(this, R.raw.operasi_perkalian_dua_matriks);
        mp_6.setLooping(false);
        mp_6.seekTo(0);
        mp_6.setVolume(0.5f, 0.5f);
        totalTime = mp_6.getDuration();

        positionBar_6.setMax(totalTime);
        positionBar_6.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if (fromUser) {
                    mp_6.seekTo(progress);
                    positionBar_6.setProgress(progress);
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (mp_6 != null) {
                    try {
                        Message msg = new Message();
                        msg.what = mp_6.getCurrentPosition();
                        handler6.sendMessage(msg);
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                    }
                }
            }
        }).start();
    }

    private Handler handler6 = new Handler() {
        @Override
        public void handleMessage(@NonNull Message msg) {
            int currentPosition = msg.what;
            positionBar_6.setProgress(currentPosition);

            String elapseTime = createTimeLabel6(currentPosition);
            elapseTimeLabel_6.setText(elapseTime);

            String remainingTime = createTimeLabel6(totalTime = currentPosition);
            remainingTimeLabel_6.setText("-" + remainingTime);
        }
    };

    public String createTimeLabel6(int time) {
        String timeLabel = "";
        int min = time / 1000 / 60;
        int sec = time / 1000 % 60;

        timeLabel = min + ":";
        if (sec < 10) timeLabel += "0";
        timeLabel += sec;

        return timeLabel;
    }

    public void playBtnClick6(View view) {
        if (!mp_6.isPlaying()) {
            mp_6.start();
            playBtn_6.setBackgroundResource(R.drawable.ic_pause);
        } else {
            mp_6.pause();
            playBtn_6.setBackgroundResource(R.drawable.ic_play);
        }
    }
//    end percakapan 6


    //    percakapan 7
    private void percakapan7() {
        mp_7 = MediaPlayer.create(this, R.raw.transpose_matriks);
        mp_7.setLooping(false);
        mp_7.seekTo(0);
        mp_7.setVolume(0.5f, 0.5f);
        totalTime = mp_7.getDuration();

        positionBar_7.setMax(totalTime);
        positionBar_7.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if (fromUser) {
                    mp_7.seekTo(progress);
                    positionBar_7.setProgress(progress);
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (mp_7 != null) {
                    try {
                        Message msg = new Message();
                        msg.what = mp_7.getCurrentPosition();
                        handler7.sendMessage(msg);
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                    }
                }
            }
        }).start();
    }

    private Handler handler7 = new Handler() {
        @Override
        public void handleMessage(@NonNull Message msg) {
            int currentPosition = msg.what;
            positionBar_7.setProgress(currentPosition);

            String elapseTime = createTimeLabel7(currentPosition);
            elapseTimeLabel_7.setText(elapseTime);

            String remainingTime = createTimeLabel7(totalTime = currentPosition);
            remainingTimeLabel_7.setText("-" + remainingTime);
        }
    };

    public String createTimeLabel7(int time) {
        String timeLabel = "";
        int min = time / 1000 / 60;
        int sec = time / 1000 % 60;

        timeLabel = min + ":";
        if (sec < 10) timeLabel += "0";
        timeLabel += sec;

        return timeLabel;
    }

    public void playBtnClick7(View view) {
        if (!mp_7.isPlaying()) {
            mp_7.start();
            playBtn_7.setBackgroundResource(R.drawable.ic_pause);
        } else {
            mp_7.pause();
            playBtn_7.setBackgroundResource(R.drawable.ic_play);
        }
    }
//    end percakapan 7


    @Override
    protected void onStop() {
        if (mp_1 != null && mp_1.isPlaying()) {
            mp_1.stop();
            mp_1.release();
            mp_1 = null;
        } else if (mp_2 != null && mp_2.isPlaying()) {
            mp_2.stop();
            mp_2.release();
            mp_2 = null;
        } else if (mp_3 != null && mp_3.isPlaying()) {
            mp_3.stop();
            mp_3.release();
            mp_3 = null;
        } else if (mp_4 != null && mp_4.isPlaying()) {
            mp_4.stop();
            mp_4.release();
            mp_4 = null;
        } else if (mp_5 != null && mp_5.isPlaying()) {
            mp_5.stop();
            mp_5.release();
            mp_5 = null;
        } else if (mp_6 != null && mp_6.isPlaying()) {
            mp_6.stop();
            mp_6.release();
            mp_6 = null;
        } else if (mp_7 != null && mp_7.isPlaying()) {
            mp_7.stop();
            mp_7.release();
            mp_7 = null;
        }

        super.onStop();
    }
}