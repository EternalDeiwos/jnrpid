package com.example.jnrpid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import jnr.ffi.LibraryLoader;
import jnr.ffi.types.pid_t;

public class MainActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
  }

  public interface LibC {
    @pid_t
    long getpid();

    @pid_t
    long getppid();
  }

  static {
    LibC lib = LibraryLoader.create(LibC.class).load("c");
    Log.d("JNR_TEST", "result: " + lib.getpid() + "/" + lib.getppid());
  }
}
