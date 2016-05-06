package com.packtpub.libgdx.collisiontest;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.physics.bullet.collision.ContactListener;
import com.badlogic.gdx.physics.bullet.collision.btCollisionObject;

public class MyContactListener extends ContactListener {
@Override
public void onContactStarted(btCollisionObject colObj0, btCollisionObject colObj1) {
	Gdx.app.log(this.getClass().getName(), "onContactStarted");

}
}
