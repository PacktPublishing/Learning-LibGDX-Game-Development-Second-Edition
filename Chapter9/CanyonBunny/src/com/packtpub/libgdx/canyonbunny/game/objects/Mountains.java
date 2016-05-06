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
import com.packtpub.libgdx.canyonbunny.game.Assets;

public class Mountains extends AbstractGameObject {

	private TextureRegion regMountainLeft;
	private TextureRegion regMountainRight;

	private int length;

	public Mountains (int length) {
		this.length = length;
		init();
	}

	private void init () {
		dimension.set(10, 2);

		regMountainLeft = Assets.instance.levelDecoration.mountainLeft;
		regMountainRight = Assets.instance.levelDecoration.mountainRight;

		// shift mountain and extend length
		origin.x = -dimension.x * 2;
		length += dimension.x * 2;
	}

	public void updateScrollPosition (Vector2 camPosition) {
		position.set(camPosition.x, position.y);
	}

	private void drawMountain (SpriteBatch batch, float offsetX, float offsetY, float tintColor, float parallaxSpeedX) {
		TextureRegion reg = null;
		batch.setColor(tintColor, tintColor, tintColor, 1);
		float xRel = dimension.x * offsetX;
		float yRel = dimension.y * offsetY;

		// mountains span the whole level
		int mountainLength = 0;
		mountainLength += MathUtils.ceil(length / (2 * dimension.x) * (1 - parallaxSpeedX));
		mountainLength += MathUtils.ceil(0.5f + offsetX);
		for (int i = 0; i < mountainLength; i++) {
			// mountain left
			reg = regMountainLeft;
			batch.draw(reg.getTexture(), origin.x + xRel + position.x * parallaxSpeedX, origin.y + yRel + position.y, origin.x,
				origin.y, dimension.x, dimension.y, scale.x, scale.y, rotation, reg.getRegionX(), reg.getRegionY(),
				reg.getRegionWidth(), reg.getRegionHeight(), false, false);
			xRel += dimension.x;
			// mountain right
			reg = regMountainRight;
			batch.draw(reg.getTexture(), origin.x + xRel + position.x * parallaxSpeedX, origin.y + yRel + position.y, origin.x,
				origin.y, dimension.x, dimension.y, scale.x, scale.y, rotation, reg.getRegionX(), reg.getRegionY(),
				reg.getRegionWidth(), reg.getRegionHeight(), false, false);
			xRel += dimension.x;
		}
		// reset color to white
		batch.setColor(1, 1, 1, 1);
	}

	@Override
	public void render (SpriteBatch batch) {
	    // 80% distant mountains (dark gray)
	    drawMountain(batch, 0.5f, 0.5f, 0.5f, 0.8f);
	    // 50% distant mountains (gray)
	    drawMountain(batch, 0.25f, 0.25f, 0.7f, 0.5f);
	    // 30% distant mountains (light gray)
	    drawMountain(batch, 0.0f, 0.0f, 0.9f, 0.3f);
	}

}
