package com.esotericsoftware.spine.attachments;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.esotericsoftware.spine.Bone;
import com.esotericsoftware.spine.Skeleton;
import com.esotericsoftware.spine.Slot;

/**
 * Class for using a libgdx group as a spine attachment
 * 
 * @author Kristoffer la Cour - Game Made Studio
 */

public class GroupAttachment extends Attachment {

	private AttachmentGroup group;
	
	public GroupAttachment(String name) {
		super(name);
	}

	public AttachmentGroup getGroup() {
		return group;
	}

	public void setGroup(AttachmentGroup label) {
		this.group = label;
	}
	
	public void updatePlacement(Slot slot, boolean premultipliedAlpha) {
		Vector2 localCoords = new Vector2();
		Skeleton skeleton = slot.getSkeleton();
		Bone bone = slot.getBone();
		float newScaleX = bone.getWorldScaleX(), newScaleY = bone.getWorldScaleY();
		
		Group parent = getGroup().getSkeletonParent();
		while (parent != null) {
			parent = parent.getParent();
			if(parent == null) 
				break;
			newScaleX *= parent.getScaleX();
			newScaleY *= parent.getScaleY();
		}
		
		if(getGroup().getSkeletonParent().getParent() != null)
			getGroup().getSkeletonParent().getParent().localToParentCoordinates(localCoords);
		else return;
		
		setX(bone.getWorldX() * getGroup().getSkeletonParent().getParent().getScaleX() + skeleton.getX() + localCoords.x);
		setY(bone.getWorldY() * getGroup().getSkeletonParent().getParent().getScaleY() + skeleton.getY() + localCoords.y);
		setScaleX(newScaleX);
		setScaleY(newScaleY);
		setRotation(bone.getWorldRotation());
		group.setColor(slot.getColor());
	}
	
	public float getX () {
		return group.getX();
	}

	public void setX (float x) {
		group.setX(x);
	}

	public float getY () {
		return group.getY();
	}

	public void setY (float y) {
		group.setY(y);
	}

	public float getScaleX () {
		return group.getScaleX();
	}

	public void setScaleX (float scaleX) {
		group.setScaleX(scaleX);
	}

	public float getScaleY () {
		return group.getScaleY();
	}

	public void setScaleY (float scaleY) {
		group.setScaleY(scaleY);
	}

	public float getRotation () {
		return group.getRotation();
	}

	public void setRotation (float rotation) {
		group.setRotation(rotation);
	}

	public float getWidth () {
		return group.getWidth();
	}

	public void setWidth (float width) {
		group.setWidth(width);
	}

	public float getHeight () {
		return group.getHeight();
	}

	public void setHeight (float height) {
		group.setHeight(height);
	}

	public Color getColor () {
		return group.getColor();
	}

}
