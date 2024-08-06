// Made with Blockbench 4.10.3
// Exported for Minecraft version 1.7 - 1.12
// Paste this class into your mod and generate all required imports

package com.vinelles.testmod.entities.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class Roots extends ModelBase {
	private final ModelRenderer bone;
	private final ModelRenderer root3;
	private final ModelRenderer cube_r1;
	private final ModelRenderer cube_r2;
	private final ModelRenderer cube_r3;
	private final ModelRenderer cube_r4;
	private final ModelRenderer cube_r5;
	private final ModelRenderer cube_r6;
	private final ModelRenderer root4;
	private final ModelRenderer cube_r7;
	private final ModelRenderer cube_r8;
	private final ModelRenderer cube_r9;
	private final ModelRenderer cube_r10;
	private final ModelRenderer cube_r11;
	private final ModelRenderer cube_r12;
	private final ModelRenderer root2;
	private final ModelRenderer cube_r13;
	private final ModelRenderer cube_r14;
	private final ModelRenderer cube_r15;
	private final ModelRenderer cube_r16;
	private final ModelRenderer cube_r17;
	private final ModelRenderer cube_r18;
	private final ModelRenderer root;
	private final ModelRenderer cube_r19;
	private final ModelRenderer cube_r20;
	private final ModelRenderer cube_r21;
	private final ModelRenderer cube_r22;
	private final ModelRenderer cube_r23;
	private final ModelRenderer cube_r24;

	public Roots() {
		textureWidth = 64;
		textureHeight = 64;

		bone = new ModelRenderer(this);
		bone.setRotationPoint(0.0F, 36.0F, 0.0F);


		root3 = new ModelRenderer(this);
		root3.setRotationPoint(0.0F, -1.0F, 4.0F);
		bone.addChild(root3);
		setRotationAngle(root3, -1.5708F, 0.2182F, 1.0036F);


		cube_r1 = new ModelRenderer(this);
		cube_r1.setRotationPoint(-7.2966F, -7.2683F, -0.6F);
		root3.addChild(cube_r1);
		setRotationAngle(cube_r1, 0.0F, 0.0F, -2.5307F);
		cube_r1.cubeList.add(new ModelBox(cube_r1, 0, 12, 0.0F, -3.0F, -0.4F, 2, 4, 2, -0.5F, false));

		cube_r2 = new ModelRenderer(this);
		cube_r2.setRotationPoint(-5.206F, -8.187F, -0.4F);
		root3.addChild(cube_r2);
		setRotationAngle(cube_r2, 0.0F, 0.0F, -2.0071F);
		cube_r2.cubeList.add(new ModelBox(cube_r2, 8, 12, 0.0F, -3.0F, -0.6F, 2, 4, 2, -0.4F, false));

		cube_r3 = new ModelRenderer(this);
		cube_r3.setRotationPoint(-2.8834F, -7.8528F, -0.3F);
		root3.addChild(cube_r3);
		setRotationAngle(cube_r3, 0.0F, 0.0F, -1.4399F);
		cube_r3.cubeList.add(new ModelBox(cube_r3, 16, 0, 0.0F, -3.0F, -0.7F, 2, 4, 2, -0.3F, false));

		cube_r4 = new ModelRenderer(this);
		cube_r4.setRotationPoint(-0.4436F, -6.9654F, -0.2F);
		root3.addChild(cube_r4);
		setRotationAngle(cube_r4, 0.0F, 0.0F, -0.829F);
		cube_r4.cubeList.add(new ModelBox(cube_r4, 16, 6, -1.0F, -3.0F, -0.8F, 2, 4, 2, -0.2F, false));

		cube_r5 = new ModelRenderer(this);
		cube_r5.setRotationPoint(2.3469F, -3.3728F, -0.1F);
		root3.addChild(cube_r5);
		setRotationAngle(cube_r5, 0.0F, 0.0F, -0.6545F);
		cube_r5.cubeList.add(new ModelBox(cube_r5, 16, 12, -1.0F, -4.0F, -0.9F, 2, 4, 2, -0.1F, false));

		cube_r6 = new ModelRenderer(this);
		cube_r6.setRotationPoint(4.3058F, -0.0891F, 0.0F);
		root3.addChild(cube_r6);
		setRotationAngle(cube_r6, 0.0F, 0.0F, -0.5672F);
		cube_r6.cubeList.add(new ModelBox(cube_r6, 0, 18, -1.0F, -4.0F, -1.0F, 2, 4, 2, 0.0F, false));

		root4 = new ModelRenderer(this);
		root4.setRotationPoint(-4.0F, 3.0F, 2.0F);
		bone.addChild(root4);
		setRotationAngle(root4, -2.935F, -0.5132F, 1.1673F);


		cube_r7 = new ModelRenderer(this);
		cube_r7.setRotationPoint(-10.6823F, -6.0361F, -0.4622F);
		root4.addChild(cube_r7);
		setRotationAngle(cube_r7, 0.0F, 0.0F, -2.5307F);
		cube_r7.cubeList.add(new ModelBox(cube_r7, 0, 0, 0.0F, -3.0F, -0.4F, 2, 4, 2, -0.5F, false));

		cube_r8 = new ModelRenderer(this);
		cube_r8.setRotationPoint(-8.5916F, -6.9547F, -0.2622F);
		root4.addChild(cube_r8);
		setRotationAngle(cube_r8, 0.0F, 0.0F, -2.0071F);
		cube_r8.cubeList.add(new ModelBox(cube_r8, 0, 6, 0.0F, -3.0F, -0.6F, 2, 4, 2, -0.4F, false));

		cube_r9 = new ModelRenderer(this);
		cube_r9.setRotationPoint(-6.269F, -6.6205F, -0.1622F);
		root4.addChild(cube_r9);
		setRotationAngle(cube_r9, 0.0F, 0.0F, -1.4399F);
		cube_r9.cubeList.add(new ModelBox(cube_r9, 8, 0, 0.0F, -3.0F, -0.7F, 2, 4, 2, -0.3F, false));

		cube_r10 = new ModelRenderer(this);
		cube_r10.setRotationPoint(-3.8292F, -5.7331F, -0.0622F);
		root4.addChild(cube_r10);
		setRotationAngle(cube_r10, 0.0F, 0.0F, -0.829F);
		cube_r10.cubeList.add(new ModelBox(cube_r10, 8, 6, -1.0F, -3.0F, -0.8F, 2, 4, 2, -0.2F, false));

		cube_r11 = new ModelRenderer(this);
		cube_r11.setRotationPoint(-1.0388F, -2.1405F, 0.0378F);
		root4.addChild(cube_r11);
		setRotationAngle(cube_r11, 0.0F, 0.0F, -0.6545F);
		cube_r11.cubeList.add(new ModelBox(cube_r11, 8, 30, -1.0F, -4.0F, -0.9F, 2, 4, 2, -0.1F, false));

		cube_r12 = new ModelRenderer(this);
		cube_r12.setRotationPoint(0.9202F, 1.1431F, 0.1378F);
		root4.addChild(cube_r12);
		setRotationAngle(cube_r12, 0.0F, 0.0F, -0.5672F);
		cube_r12.cubeList.add(new ModelBox(cube_r12, 30, 24, -1.0F, -4.0F, -1.0F, 2, 4, 2, 0.0F, false));

		root2 = new ModelRenderer(this);
		root2.setRotationPoint(-2.0F, 3.0F, -4.0F);
		bone.addChild(root2);
		setRotationAngle(root2, 1.5708F, 0.0436F, 2.138F);


		cube_r13 = new ModelRenderer(this);
		cube_r13.setRotationPoint(-11.7406F, -7.4624F, -1.0624F);
		root2.addChild(cube_r13);
		setRotationAngle(cube_r13, 0.0F, 0.0F, -2.5307F);
		cube_r13.cubeList.add(new ModelBox(cube_r13, 8, 18, 0.0F, -3.0F, -0.4F, 2, 4, 2, -0.5F, false));

		cube_r14 = new ModelRenderer(this);
		cube_r14.setRotationPoint(-9.6499F, -8.381F, -0.8624F);
		root2.addChild(cube_r14);
		setRotationAngle(cube_r14, 0.0F, 0.0F, -2.0071F);
		cube_r14.cubeList.add(new ModelBox(cube_r14, 16, 18, 0.0F, -3.0F, -0.6F, 2, 4, 2, -0.4F, false));

		cube_r15 = new ModelRenderer(this);
		cube_r15.setRotationPoint(-7.3273F, -8.0468F, -0.7624F);
		root2.addChild(cube_r15);
		setRotationAngle(cube_r15, 0.0F, 0.0F, -1.4399F);
		cube_r15.cubeList.add(new ModelBox(cube_r15, 22, 22, 0.0F, -3.0F, -0.7F, 2, 4, 2, -0.3F, false));

		cube_r16 = new ModelRenderer(this);
		cube_r16.setRotationPoint(-4.8875F, -7.1594F, -0.6624F);
		root2.addChild(cube_r16);
		setRotationAngle(cube_r16, 0.0F, 0.0F, -0.829F);
		cube_r16.cubeList.add(new ModelBox(cube_r16, 0, 24, -1.0F, -3.0F, -0.8F, 2, 4, 2, -0.2F, false));

		cube_r17 = new ModelRenderer(this);
		cube_r17.setRotationPoint(-2.0971F, -3.5668F, -0.5624F);
		root2.addChild(cube_r17);
		setRotationAngle(cube_r17, 0.0F, 0.0F, -0.6545F);
		cube_r17.cubeList.add(new ModelBox(cube_r17, 24, 0, -1.0F, -4.0F, -0.9F, 2, 4, 2, -0.1F, false));

		cube_r18 = new ModelRenderer(this);
		cube_r18.setRotationPoint(-0.1381F, -0.2832F, -0.4624F);
		root2.addChild(cube_r18);
		setRotationAngle(cube_r18, 0.0F, 0.0F, -0.5672F);
		cube_r18.cubeList.add(new ModelBox(cube_r18, 24, 6, -1.0F, -4.0F, -1.0F, 2, 4, 2, 0.0F, false));

		root = new ModelRenderer(this);
		root.setRotationPoint(4.0F, 3.0F, -3.0F);
		bone.addChild(root);
		setRotationAngle(root, 0.137F, 0.5522F, 1.8278F);


		cube_r19 = new ModelRenderer(this);
		cube_r19.setRotationPoint(-12.1639F, -6.1893F, -0.219F);
		root.addChild(cube_r19);
		setRotationAngle(cube_r19, 0.0F, 0.0F, -2.5307F);
		cube_r19.cubeList.add(new ModelBox(cube_r19, 8, 24, 0.0F, -3.0F, -0.4F, 2, 4, 2, -0.5F, false));

		cube_r20 = new ModelRenderer(this);
		cube_r20.setRotationPoint(-10.0733F, -7.1079F, -0.019F);
		root.addChild(cube_r20);
		setRotationAngle(cube_r20, 0.0F, 0.0F, -2.0071F);
		cube_r20.cubeList.add(new ModelBox(cube_r20, 24, 12, 0.0F, -3.0F, -0.6F, 2, 4, 2, -0.4F, false));

		cube_r21 = new ModelRenderer(this);
		cube_r21.setRotationPoint(-7.7507F, -6.7737F, 0.081F);
		root.addChild(cube_r21);
		setRotationAngle(cube_r21, 0.0F, 0.0F, -1.4399F);
		cube_r21.cubeList.add(new ModelBox(cube_r21, 16, 26, 0.0F, -3.0F, -0.7F, 2, 4, 2, -0.3F, false));

		cube_r22 = new ModelRenderer(this);
		cube_r22.setRotationPoint(-5.3109F, -5.8863F, 0.181F);
		root.addChild(cube_r22);
		setRotationAngle(cube_r22, 0.0F, 0.0F, -0.829F);
		cube_r22.cubeList.add(new ModelBox(cube_r22, 28, 18, -1.0F, -3.0F, -0.8F, 2, 4, 2, -0.2F, false));

		cube_r23 = new ModelRenderer(this);
		cube_r23.setRotationPoint(-2.5204F, -2.2937F, 0.281F);
		root.addChild(cube_r23);
		setRotationAngle(cube_r23, 0.0F, 0.0F, -0.6545F);
		cube_r23.cubeList.add(new ModelBox(cube_r23, 24, 28, -1.0F, -4.0F, -0.9F, 2, 4, 2, -0.1F, false));

		cube_r24 = new ModelRenderer(this);
		cube_r24.setRotationPoint(-0.5615F, 0.9899F, 0.381F);
		root.addChild(cube_r24);
		setRotationAngle(cube_r24, 0.0F, 0.0F, -0.5672F);
		cube_r24.cubeList.add(new ModelBox(cube_r24, 0, 30, -1.0F, -4.0F, -1.0F, 2, 4, 2, 0.0F, false));
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		bone.render(f5);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}

	public void setAnimationTime(float time) {
		float root3Rot = -1.5708F + time * (1.0036F + 1.5708F);
		setRotationAngle(root3, root3Rot, 0.2182F, 1.0036F);
		// Add similar transformations for other parts based on keyframes.
	}
}
