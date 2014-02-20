package com.esotericsoftware.spine.attachments;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Group;

public class AttachmentGroup extends Group {
	private Group parent;
	
	public AttachmentGroup(Group parent) {
		super();
		this.parent = parent;
	}

	public Group getSkeletonParent() {
		return parent;
	}

	@Override
	public void draw(Batch batch, float parentAlpha) {
		if(getColor().a != 0) {
			super.draw(batch, parentAlpha);
		}
	}
}
