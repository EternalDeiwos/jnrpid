package com.example.jnrpid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import jnr.ffi.LibraryLoader;
import jnr.ffi.types.pid_t;

public class MainActivity extends AppCompatActivity {
  private static final String TAG = MainActivity.class.getSimpleName();

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    SharedLibraryLoader.loadLibrary("jffi-1.2", this.getApplicationContext());
    LibC lib = LibraryLoader.create(LibC.class).load("c");
    Log.d(TAG, "result: " + lib.getpid() + "/" + lib.getppid());
  }

  public interface LibC {
    @pid_t
    long getpid();

    @pid_t
    long getppid();
  }
}
