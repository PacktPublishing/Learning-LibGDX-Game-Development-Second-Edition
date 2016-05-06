package com.packtpub.libgdx.collisiontest;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.g3d.ModelInstance;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.physics.bullet.dynamics.btRigidBody;
import com.badlogic.gdx.physics.bullet.dynamics.btRigidBody.btRigidBodyConstructionInfo;
import com.badlogic.gdx.physics.bullet.linearmath.btMotionState;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Disposable;

public class UserData implements Disposable {

	public static final Array<UserData> data = new Array<UserData>();
	private static final Vector3 temp = new Vector3();
	final ModelInstance instance;
	final btMotionState motionState;
	final btRigidBody body;
	final btRigidBodyConstructionInfo bodyInfo;

	public UserData(ModelInstance instance, btMotionState motionState, btRigidBodyConstructionInfo bodyInfo, btRigidBody body) {
		this.instance = instance;
		this.motionState = motionState;
		this.bodyInfo = bodyInfo;
		this.body = body;
		data.add(this);
	}

	public btRigidBody getBody() {
		return body;
	}

	public ModelInstance getInstance() {
		return this.instance;
	}

	public boolean isVisible(Camera cam) {
		return cam.frustum.pointInFrustum(instance.transform.getTranslation(temp));
	}

	@Override
	public void dispose() {
		if (motionState != null) {
			motionState.dispose();
		}
		bodyInfo.dispose();
		body.dispose();

		data.removeValue(this, true);
		Gdx.app.log(this.getClass().getName(), " Rigid body removed and disposed.");
	}

}
