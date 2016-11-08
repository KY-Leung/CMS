package com.control;

import java.util.ArrayList;

import com.entity.Settings;
import com.entity.User;

public interface SettingsDao {


		public void createSettings(boolean viaSms,boolean hazeInfo,boolean fireInfo,boolean maskInfo,boolean bombshelterInfo);
		public void updateSms(boolean x);
		public void updateHazeInfo(boolean x);
		public void updateBombshelterinfo(boolean x);
		public void updateFireInfo(boolean x);
		public void updateMaskInfo(boolean x);
		public Settings getSettings();
		public ArrayList<User> getHazeInfoUsers();
		public ArrayList<User> getFireInfoUsers();
		public ArrayList<User> getMaskInfoUsers();
		public ArrayList<User> getBombshelterInfoUsers();


}
