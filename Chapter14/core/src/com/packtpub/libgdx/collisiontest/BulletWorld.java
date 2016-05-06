package com.packtpub.libgdx.collisiontest;

import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.physics.bullet.Bullet;
import com.badlogic.gdx.physics.bullet.collision.btCollisionDispatcher;
import com.badlogic.gdx.physics.bullet.collision.btDbvtBroadphase;
import com.badlogic.gdx.physics.bullet.collision.btDefaultCollisionConfiguration;
import com.badlogic.gdx.physics.bullet.dynamics.btDiscreteDynamicsWorld;
import com.badlogic.gdx.physics.bullet.dynamics.btRigidBody;
import com.badlogic.gdx.physics.bullet.dynamics.btSequentialImpulseConstraintSolver;

public class BulletWorld implements MyBulletInterface {
	protected btDefaultCollisionConfiguration collisionConfiguration;
	protected btCollisionDispatcher dispatcher;
	protected btDbvtBroadphase broadphase;
	protected btSequentialImpulseConstraintSolver solver;
	protected btDiscreteDynamicsWorld world;

	protected BulletWorld() {

	}

	@Override
	public void init() {
		Bullet.init();
		collisionConfiguration = new btDefaultCollisionConfiguration();
		dispatcher = new btCollisionDispatcher(collisionConfiguration);
		broadphase = new btDbvtBroadphase();
		solver = new btSequentialImpulseConstraintSolver();
		world = new btDiscreteDynamicsWorld(dispatcher, broadphase, solver, collisionConfiguration);
		world.setGravity(new Vector3(0, -9.81f, .1f));

	}

	@Override
	public void update(float delta) {
		world.stepSimulation(delta, 5 , 1/60f);
	}

	@Override
	public void dispose() {
		world.dispose();
		collisionConfiguration.dispose();
		dispatcher.dispose();
		broadphase.dispose();
		solver.dispose();
	}

	@Override
	public btDiscreteDynamicsWorld getWorld() {
		return world ;
	}

	@Override
	public void remove(btRigidBody body) {
		world.removeRigidBody(body);
		((UserData) body.userData).dispose();

	}

}
