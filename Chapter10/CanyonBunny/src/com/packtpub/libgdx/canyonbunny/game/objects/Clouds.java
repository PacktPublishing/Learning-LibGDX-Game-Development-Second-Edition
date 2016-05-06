/*******************************************************************************
 * Copyright 2013 Andreas Oehlke
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *   http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 ******************************************************************************/


package com.packtpub.libgdx.canyonbunny.game.objects;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;
import com.packtpub.libgdx.canyonbunny.game.Assets;

public class Clouds extends AbstractGameObject {

	private float length;

	private Array<TextureRegion> regClouds;
	private Array<Cloud> clouds;

	private class Cloud extends AbstractGameObject {
		private TextureRegion regCloud;

		public Cloud () {
		}

		public void setRegion (TextureRegion region) {
			regCloud = region;
		}

		@Override
		public void render (SpriteBatch batch) {
			TextureRegion reg = regCloud;
			batch.draw(reg.getTexture(), position.x + origin.x, position.y + origin.y, origin.x, origin.y, dimension.x, dimension.y,
				scale.x, scale.y, rotation, reg.getRegionX(), reg.getRegionY(), reg.getRegionWidth(), reg.getRegionHeight(), false,
				false);
		}
	}

	public Clouds (float length) {
		this.length = length;
		init();
	}

	private void init () {
		dimension.set(3.0f, 1.5f);

		regClouds = new Array<TextureRegion>();
		regClouds.add(Assets.instance.levelDecoration.cloud01);
		regClouds.add(Assets.instance.levelDecoration.cloud02);
		regClouds.add(Assets.instance.levelDecoration.cloud03);

		int distFac = 5;
		int numClouds = (int)(length / distFac);
		clouds = new Array<Cloud>(2 * numClouds);
		for (int i = 0; i < numClouds; i++) {
			Cloud cloud = spawnCloud();
			cloud.position.x = i * distFac;
			clouds.add(cloud);
		}
	}

	private Cloud spawnCloud () {
		Cloud cloud = new Cloud();
		cloud.dimension.set(dimension);
		// select random cloud image
		cloud.setRegion(regClouds.random());
		// position
		Vector2 pos = new Vector2();
		pos.x = length + 10; // position after end of level
		pos.y += 1.75; // base position
		pos.y += MathUtils.random(0.0f, 0.2f) * (MathUtils.randomBoolean() ? 1 : -1); // random additional position
		cloud.position.set(pos);
		// speed
		Vector2 speed = new Vector2();
		speed.x += 0.5f; // base speed
		speed.x += MathUtils.random(0.0f, 0.75f); // random additional speed
		cloud.terminalVelocity.set(speed);
		speed.x *= -1; // move left
		cloud.velocity.set(speed);
		return cloud;
	}

	@Override
	public void update (float deltaTime) {
		for (int i = clouds.size - 1; i >= 0; i--) {
			Cloud cloud = clouds.get(i);
			cloud.update(deltaTime);
			if (cloud.position.x < -10) {
				// cloud moved outside of world.
				// destroy and spawn new cloud at end of level.
				clouds.removeIndex(i);
				clouds.add(spawnCloud());
			}
		}
	}

	@Override
	public void render (SpriteBatch batch) {
		for (Cloud cloud : clouds)
			cloud.render(batch);
	}

}
