package com.packtpub.libgdx.collisiontest;

import com.badlogic.gdx.graphics.g3d.ModelInstance;
import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.physics.bullet.linearmath.btMotionState;

public class MyMotionState extends btMotionState {
private final ModelInstance instance;
public MyMotionState(ModelInstance instance) {
	this.instance = instance;
}

@Override
public void getWorldTransform(Matrix4 worldTrans) {
	worldTrans.set(instance.transform);
}

@Override
public void setWorldTransform(Matrix4 worldTrans) {
	instance.transform.set(worldTrans);
}
}
