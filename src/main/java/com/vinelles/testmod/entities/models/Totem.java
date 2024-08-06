package com.vinelles.testmod.entities.models;// Made with Blockbench 4.10.3
// Exported for Minecraft version 1.7 - 1.12
// Paste this class into your mod and generate all required imports


import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class Totem extends ModelBase {
	private final ModelRenderer wingr;
	private final ModelRenderer cube_r1;
	private final ModelRenderer cube_r2;
	private final ModelRenderer cube_r3;
	private final ModelRenderer cube_r4;
	private final ModelRenderer wing;
	private final ModelRenderer cube_r5;
	private final ModelRenderer cube_r6;
	private final ModelRenderer cube_r7;
	private final ModelRenderer cube_r8;
	private final ModelRenderer body;
	private final ModelRenderer cube_r9;
	private final ModelRenderer cube_r10;
	private final ModelRenderer cube_r11;
	private final ModelRenderer cube_r12;
	private final ModelRenderer cube_r13;
	private final ModelRenderer cube_r14;
	private final ModelRenderer cube_r15;
	private final ModelRenderer cube_r16;
	private final ModelRenderer cube_r17;
	private final ModelRenderer cube_r18;
	private final ModelRenderer cube_r19;
	private final ModelRenderer cube_r20;
	private final ModelRenderer cube_r21;
	private final ModelRenderer cube_r22;
	private final ModelRenderer cube_r23;
	private final ModelRenderer cube_r24;
	private final ModelRenderer cube_r25;
	private final ModelRenderer cube_r26;
	private final ModelRenderer cube_r27;
	private final ModelRenderer cube_r28;
	private final ModelRenderer cube_r29;
	private final ModelRenderer horn;
	private final ModelRenderer cube_r30;
	private final ModelRenderer cube_r31;
	private final ModelRenderer cube_r32;
	private final ModelRenderer cube_r33;
	private final ModelRenderer horn2;
	private final ModelRenderer cube_r34;
	private final ModelRenderer cube_r35;
	private final ModelRenderer cube_r36;
	private final ModelRenderer cube_r37;

	public Totem() {
		textureWidth = 64;
		textureHeight = 64;

		wingr = new ModelRenderer(this);
		wingr.setRotationPoint(5.0F, 21.0F, 0.0F);
		

		cube_r1 = new ModelRenderer(this);
		cube_r1.setRotationPoint(0.0F, 0.0F, 0.0F);
		wingr.addChild(cube_r1);
		setRotationAngle(cube_r1, 0.0F, 1.5708F, 1.5708F);
		cube_r1.cubeList.add(new ModelBox(cube_r1, 42, 32, -1.0F, -6.0F, -5.0F, 2, 6, 1, 0.0F, false));

		cube_r2 = new ModelRenderer(this);
		cube_r2.setRotationPoint(0.0F, 1.0F, 0.0F);
		wingr.addChild(cube_r2);
		setRotationAngle(cube_r2, 0.0F, 1.5708F, 1.5708F);
		cube_r2.cubeList.add(new ModelBox(cube_r2, 10, 44, -1.0F, -5.0F, -5.0F, 2, 5, 1, 0.0F, false));

		cube_r3 = new ModelRenderer(this);
		cube_r3.setRotationPoint(0.0F, 2.0F, 0.0F);
		wingr.addChild(cube_r3);
		setRotationAngle(cube_r3, 0.0F, 1.5708F, 1.5708F);
		cube_r3.cubeList.add(new ModelBox(cube_r3, 48, 25, -1.0F, -3.0F, -5.0F, 2, 3, 1, 0.0F, false));

		cube_r4 = new ModelRenderer(this);
		cube_r4.setRotationPoint(0.0F, -1.0F, 0.0F);
		wingr.addChild(cube_r4);
		setRotationAngle(cube_r4, 0.0F, 1.5708F, 1.5708F);
		cube_r4.cubeList.add(new ModelBox(cube_r4, 42, 45, -1.0F, -7.0F, -5.0F, 2, 5, 1, 0.0F, false));

		wing = new ModelRenderer(this);
		wing.setRotationPoint(-5.0F, 21.0F, 0.0F);
		setRotationAngle(wing, 0.0F, 3.1416F, 0.0F);
		

		cube_r5 = new ModelRenderer(this);
		cube_r5.setRotationPoint(0.0F, 0.0F, 0.0F);
		wing.addChild(cube_r5);
		setRotationAngle(cube_r5, 0.0F, 1.5708F, 1.5708F);
		cube_r5.cubeList.add(new ModelBox(cube_r5, 42, 25, -1.0F, -6.0F, -5.0F, 2, 6, 1, 0.0F, false));

		cube_r6 = new ModelRenderer(this);
		cube_r6.setRotationPoint(0.0F, 1.0F, 0.0F);
		wing.addChild(cube_r6);
		setRotationAngle(cube_r6, 0.0F, 1.5708F, 1.5708F);
		cube_r6.cubeList.add(new ModelBox(cube_r6, 42, 39, -1.0F, -5.0F, -5.0F, 2, 5, 1, 0.0F, false));

		cube_r7 = new ModelRenderer(this);
		cube_r7.setRotationPoint(0.0F, 2.0F, 0.0F);
		wing.addChild(cube_r7);
		setRotationAngle(cube_r7, 0.0F, 1.5708F, 1.5708F);
		cube_r7.cubeList.add(new ModelBox(cube_r7, 13, 5, -1.0F, -3.0F, -5.0F, 2, 3, 1, 0.0F, false));

		cube_r8 = new ModelRenderer(this);
		cube_r8.setRotationPoint(0.0F, -1.0F, 0.0F);
		wing.addChild(cube_r8);
		setRotationAngle(cube_r8, 0.0F, 1.5708F, 1.5708F);
		cube_r8.cubeList.add(new ModelBox(cube_r8, 4, 44, -1.0F, -7.0F, -5.0F, 2, 5, 1, 0.0F, false));

		body = new ModelRenderer(this);
		body.setRotationPoint(0.0F, 24.0F, -2.0F);
		body.cubeList.add(new ModelBox(body, 0, 0, -1.0F, -14.0F, -2.0F, 2, 14, 9, 0.0F, false));

		cube_r9 = new ModelRenderer(this);
		cube_r9.setRotationPoint(0.0F, 0.0F, 0.0F);
		body.addChild(cube_r9);
		setRotationAngle(cube_r9, 0.0F, 1.5708F, 0.0F);
		cube_r9.cubeList.add(new ModelBox(cube_r9, 38, 33, -1.0F, -16.0F, -4.0F, 1, 16, 1, 0.0F, false));

		cube_r10 = new ModelRenderer(this);
		cube_r10.setRotationPoint(2.0F, 0.0F, 0.0F);
		body.addChild(cube_r10);
		setRotationAngle(cube_r10, 0.0F, 1.5708F, 0.0F);
		cube_r10.cubeList.add(new ModelBox(cube_r10, 0, 23, -1.0F, -14.0F, -5.0F, 2, 14, 2, 0.0F, false));

		cube_r11 = new ModelRenderer(this);
		cube_r11.setRotationPoint(2.0F, 0.0F, -2.0F);
		body.addChild(cube_r11);
		setRotationAngle(cube_r11, 0.0F, 1.5708F, 0.0F);
		cube_r11.cubeList.add(new ModelBox(cube_r11, 0, 39, -1.0F, -16.0F, -4.0F, 1, 16, 1, 0.0F, false));

		cube_r12 = new ModelRenderer(this);
		cube_r12.setRotationPoint(5.0F, 0.0F, -2.0F);
		body.addChild(cube_r12);
		setRotationAngle(cube_r12, 0.0F, 1.5708F, 0.0F);
		cube_r12.cubeList.add(new ModelBox(cube_r12, 30, 34, -1.0F, -16.0F, -4.0F, 1, 16, 1, 0.0F, false));

		cube_r13 = new ModelRenderer(this);
		cube_r13.setRotationPoint(7.0F, 0.0F, 0.0F);
		body.addChild(cube_r13);
		setRotationAngle(cube_r13, 0.0F, 1.5708F, 0.0F);
		cube_r13.cubeList.add(new ModelBox(cube_r13, 34, 34, -1.0F, -16.0F, -4.0F, 1, 16, 1, 0.0F, false));

		cube_r14 = new ModelRenderer(this);
		cube_r14.setRotationPoint(6.0F, 0.0F, 0.0F);
		body.addChild(cube_r14);
		setRotationAngle(cube_r14, 0.0F, 1.5708F, 0.0F);
		cube_r14.cubeList.add(new ModelBox(cube_r14, 34, 0, -1.0F, -14.0F, -5.0F, 2, 14, 2, 0.0F, false));

		cube_r15 = new ModelRenderer(this);
		cube_r15.setRotationPoint(6.0F, 0.0F, 2.0F);
		body.addChild(cube_r15);
		setRotationAngle(cube_r15, 0.0F, 1.5708F, 0.0F);
		cube_r15.cubeList.add(new ModelBox(cube_r15, 18, 19, -1.0F, -14.0F, -5.0F, 2, 14, 4, 0.0F, false));

		cube_r16 = new ModelRenderer(this);
		cube_r16.setRotationPoint(7.0F, 0.0F, 3.0F);
		body.addChild(cube_r16);
		setRotationAngle(cube_r16, 0.0F, 1.5708F, 0.0F);
		cube_r16.cubeList.add(new ModelBox(cube_r16, 16, 37, -1.0F, -16.0F, -4.0F, 1, 16, 1, 0.0F, false));

		cube_r17 = new ModelRenderer(this);
		cube_r17.setRotationPoint(5.0F, 0.0F, 5.0F);
		body.addChild(cube_r17);
		setRotationAngle(cube_r17, 0.0F, 1.5708F, 0.0F);
		cube_r17.cubeList.add(new ModelBox(cube_r17, 20, 37, -1.0F, -16.0F, -4.0F, 1, 16, 1, 0.0F, false));

		cube_r18 = new ModelRenderer(this);
		cube_r18.setRotationPoint(6.0F, 0.0F, 4.0F);
		body.addChild(cube_r18);
		setRotationAngle(cube_r18, 0.0F, 1.5708F, 0.0F);
		cube_r18.cubeList.add(new ModelBox(cube_r18, 30, 18, -1.0F, -14.0F, -5.0F, 2, 14, 2, 0.0F, false));
		cube_r18.cubeList.add(new ModelBox(cube_r18, 30, 0, -1.0F, -16.0F, -4.0F, 1, 2, 1, 0.0F, false));

		cube_r19 = new ModelRenderer(this);
		cube_r19.setRotationPoint(1.0F, 0.0F, -1.0F);
		body.addChild(cube_r19);
		setRotationAngle(cube_r19, 0.0F, 1.5708F, 0.0F);
		cube_r19.cubeList.add(new ModelBox(cube_r19, 21, 0, -1.0F, -16.0F, -4.0F, 1, 2, 1, 0.0F, false));

		cube_r20 = new ModelRenderer(this);
		cube_r20.setRotationPoint(3.0F, 0.0F, -3.0F);
		body.addChild(cube_r20);
		setRotationAngle(cube_r20, 0.0F, 1.5708F, 0.0F);
		cube_r20.cubeList.add(new ModelBox(cube_r20, 4, 3, -1.0F, -16.0F, -4.0F, 0, 2, 2, 0.0F, false));

		cube_r21 = new ModelRenderer(this);
		cube_r21.setRotationPoint(6.0F, 0.0F, -1.0F);
		body.addChild(cube_r21);
		setRotationAngle(cube_r21, 0.0F, 1.5708F, 0.0F);
		cube_r21.cubeList.add(new ModelBox(cube_r21, 26, 18, -1.0F, -16.0F, -4.0F, 1, 2, 1, 0.0F, false));

		cube_r22 = new ModelRenderer(this);
		cube_r22.setRotationPoint(-1.0F, 0.0F, 2.0F);
		body.addChild(cube_r22);
		setRotationAngle(cube_r22, 0.0F, 1.5708F, 0.0F);
		cube_r22.cubeList.add(new ModelBox(cube_r22, 48, 29, -1.0F, -16.0F, -4.0F, 2, 2, 1, 0.0F, false));

		cube_r23 = new ModelRenderer(this);
		cube_r23.setRotationPoint(8.0F, 0.0F, 2.0F);
		body.addChild(cube_r23);
		setRotationAngle(cube_r23, 0.0F, 1.5708F, 0.0F);
		cube_r23.cubeList.add(new ModelBox(cube_r23, 48, 32, -1.0F, -16.0F, -4.0F, 2, 2, 1, 0.0F, false));

		cube_r24 = new ModelRenderer(this);
		cube_r24.setRotationPoint(3.0F, 0.0F, 6.0F);
		body.addChild(cube_r24);
		setRotationAngle(cube_r24, 0.0F, 1.5708F, 0.0F);
		cube_r24.cubeList.add(new ModelBox(cube_r24, 0, 5, -1.0F, -16.0F, -4.0F, 1, 2, 2, 0.0F, false));

		cube_r25 = new ModelRenderer(this);
		cube_r25.setRotationPoint(1.0F, 0.0F, 4.0F);
		body.addChild(cube_r25);
		setRotationAngle(cube_r25, 0.0F, 1.5708F, 0.0F);
		cube_r25.cubeList.add(new ModelBox(cube_r25, 12, 39, -1.0F, -16.0F, -4.0F, 1, 2, 1, 0.0F, false));

		cube_r26 = new ModelRenderer(this);
		cube_r26.setRotationPoint(2.0F, 0.0F, 5.0F);
		body.addChild(cube_r26);
		setRotationAngle(cube_r26, 0.0F, 1.5708F, 0.0F);
		cube_r26.cubeList.add(new ModelBox(cube_r26, 24, 37, -1.0F, -16.0F, -4.0F, 1, 16, 1, 0.0F, false));

		cube_r27 = new ModelRenderer(this);
		cube_r27.setRotationPoint(2.0F, 0.0F, 4.0F);
		body.addChild(cube_r27);
		setRotationAngle(cube_r27, 0.0F, 1.5708F, 0.0F);
		cube_r27.cubeList.add(new ModelBox(cube_r27, 8, 23, -1.0F, -14.0F, -5.0F, 2, 14, 2, 0.0F, false));

		cube_r28 = new ModelRenderer(this);
		cube_r28.setRotationPoint(0.0F, 0.0F, 3.0F);
		body.addChild(cube_r28);
		setRotationAngle(cube_r28, 0.0F, 1.5708F, 0.0F);
		cube_r28.cubeList.add(new ModelBox(cube_r28, 38, 16, -1.0F, -16.0F, -4.0F, 1, 16, 1, 0.0F, false));

		cube_r29 = new ModelRenderer(this);
		cube_r29.setRotationPoint(0.0F, 0.0F, 2.0F);
		body.addChild(cube_r29);
		setRotationAngle(cube_r29, 0.0F, 1.5708F, 0.0F);
		cube_r29.cubeList.add(new ModelBox(cube_r29, 22, 0, -1.0F, -14.0F, -5.0F, 2, 14, 4, 0.0F, false));

		horn = new ModelRenderer(this);
		horn.setRotationPoint(11.0F, 0.0F, 2.0F);
		body.addChild(horn);
		

		cube_r30 = new ModelRenderer(this);
		cube_r30.setRotationPoint(-1.8719F, -18.2838F, 0.001F);
		horn.addChild(cube_r30);
		setRotationAngle(cube_r30, 0.0F, 1.5708F, -0.1745F);
		cube_r30.cubeList.add(new ModelBox(cube_r30, 42, 10, -1.0F, -3.0F, -1.0F, 2, 3, 2, 0.0F, false));

		cube_r31 = new ModelRenderer(this);
		cube_r31.setRotationPoint(-2.6294F, -15.82F, 0.001F);
		horn.addChild(cube_r31);
		setRotationAngle(cube_r31, 0.0F, 1.5708F, 0.2618F);
		cube_r31.cubeList.add(new ModelBox(cube_r31, 13, 0, -1.0F, -3.0F, -1.0F, 2, 3, 2, -0.004F, false));

		cube_r32 = new ModelRenderer(this);
		cube_r32.setRotationPoint(-4.5487F, -14.2728F, 0.0F);
		horn.addChild(cube_r32);
		setRotationAngle(cube_r32, 0.0F, 1.5708F, 0.829F);
		cube_r32.cubeList.add(new ModelBox(cube_r32, 42, 15, -1.0F, -3.0F, -1.0F, 2, 3, 2, -0.002F, false));

		cube_r33 = new ModelRenderer(this);
		cube_r33.setRotationPoint(-7.0F, -14.0F, 0.0F);
		horn.addChild(cube_r33);
		setRotationAngle(cube_r33, 0.0F, 1.5708F, 1.3963F);
		cube_r33.cubeList.add(new ModelBox(cube_r33, 42, 20, -1.0F, -3.0F, -1.0F, 2, 3, 2, 0.001F, false));

		horn2 = new ModelRenderer(this);
		horn2.setRotationPoint(-11.0F, 0.0F, 2.0F);
		body.addChild(horn2);
		setRotationAngle(horn2, 0.0F, 3.1416F, 0.0F);
		

		cube_r34 = new ModelRenderer(this);
		cube_r34.setRotationPoint(-1.8719F, -18.2838F, 0.001F);
		horn2.addChild(cube_r34);
		setRotationAngle(cube_r34, 0.0F, 1.5708F, -0.1745F);
		cube_r34.cubeList.add(new ModelBox(cube_r34, 4, 39, -1.0F, -3.0F, -1.0F, 2, 3, 2, 0.0F, false));

		cube_r35 = new ModelRenderer(this);
		cube_r35.setRotationPoint(-2.6294F, -15.82F, 0.001F);
		horn2.addChild(cube_r35);
		setRotationAngle(cube_r35, 0.0F, 1.5708F, 0.2618F);
		cube_r35.cubeList.add(new ModelBox(cube_r35, 0, 0, -1.0F, -3.0F, -1.0F, 2, 3, 2, -0.004F, false));

		cube_r36 = new ModelRenderer(this);
		cube_r36.setRotationPoint(-4.5487F, -14.2728F, 0.0F);
		horn2.addChild(cube_r36);
		setRotationAngle(cube_r36, 0.0F, 1.5708F, 0.829F);
		cube_r36.cubeList.add(new ModelBox(cube_r36, 42, 0, -1.0F, -3.0F, -1.0F, 2, 3, 2, -0.002F, false));

		cube_r37 = new ModelRenderer(this);
		cube_r37.setRotationPoint(-7.0F, -14.0F, 0.0F);
		horn2.addChild(cube_r37);
		setRotationAngle(cube_r37, 0.0F, 1.5708F, 1.3963F);
		cube_r37.cubeList.add(new ModelBox(cube_r37, 42, 5, -1.0F, -3.0F, -1.0F, 2, 3, 2, 0.001F, false));
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		wingr.render(f5);
		wing.render(f5);
		body.render(f5);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}