package com.sanjid.game.sprites;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;

public class Bird {
    private static final int GRAVITY = -10;//utha namar gravity force control
    private static final int MOVEMENT = 50;
    private Vector3 position;
    private Rectangle bounds;


    private Vector3 velocity;
    private Texture texture;
    private Animation birdAnimation;
    private Sound flap;

    public Bird(int x, int y){
        position = new Vector3(x, y, 0);
        velocity = new Vector3(0, 0, 0);
        // bird = new Texture("bird.png");
        texture = new Texture("birdanimation.png");
        birdAnimation = new Animation(new TextureRegion(texture), 3, 0.5f);
        bounds = new Rectangle(x, y, texture.getWidth() / 3, texture.getHeight());
        flap = Gdx.audio.newSound(Gdx.files.internal("sfx_wing.ogg"));
    }
    public void update(float dt){
        birdAnimation.update(dt);
        if(position.y>0) velocity.add(0, GRAVITY, 0);
        velocity.scl(dt);
        position.add(MOVEMENT*dt,velocity.y,0);
        velocity.scl(1 / dt);
        if(position.y<0){
            position.y = 0;
        }
        bounds.setPosition(position.x, position.y);
    }

    public Vector3 getPosition() {
        return position;
    }
    public TextureRegion getTexture(){
        return birdAnimation.getFrame();
    }

    public void jump(){

        velocity.y = 200;
        flap.play(0.5f);

    }
    public Rectangle getBounds(){
        return bounds;
    }
    public void dispose(){
        texture.dispose();
    }

}