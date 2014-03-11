package com.cgsg.it_works;

import android.hardware.SensorManager;
import android.media.FaceDetector;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import org.anddev.andengine.engine.Engine;
import org.anddev.andengine.engine.camera.Camera;
import org.anddev.andengine.engine.options.EngineOptions;
import org.anddev.andengine.engine.options.resolutionpolicy.RatioResolutionPolicy;
import org.anddev.andengine.entity.primitive.Rectangle;
import org.anddev.andengine.entity.scene.Scene;
import org.anddev.andengine.entity.scene.background.ColorBackground;
import org.anddev.andengine.entity.shape.Shape;
import org.anddev.andengine.entity.sprite.AnimatedSprite;
import org.anddev.andengine.entity.sprite.Sprite;
import org.anddev.andengine.extension.physics.box2d.PhysicsConnector;
import org.anddev.andengine.extension.physics.box2d.PhysicsFactory;
import org.anddev.andengine.extension.physics.box2d.PhysicsWorld;
import org.anddev.andengine.input.touch.TouchEvent;
import org.anddev.andengine.opengl.texture.TextureOptions;
import org.anddev.andengine.opengl.texture.atlas.bitmap.BitmapTextureAtlas;
import org.anddev.andengine.opengl.texture.atlas.bitmap.BitmapTextureAtlasTextureRegionFactory;
import org.anddev.andengine.opengl.texture.region.TextureRegion;
import org.anddev.andengine.opengl.texture.region.TiledTextureRegion;
import org.anddev.andengine.sensor.accelerometer.AccelerometerData;
import org.anddev.andengine.sensor.accelerometer.IAccelerometerListener;
import org.anddev.andengine.ui.activity.BaseGameActivity;

/**
 * Created with IntelliJ IDEA.
 * User: Yaroslav
 * Date: 11.03.14
 * Time: 16:53
 * To change this template use File | Settings | File Templates.
 */
public class TestActivity extends BaseGameActivity implements Scene.IOnSceneTouchListener {
    private Camera camera;
    private int width = 720, height = 480;

    private Scene mScene;
    private BitmapTextureAtlas mBitmapTextureAtlas;
    private PhysicsWorld mPhysicsWorld;

    private TextureRegion ballTextureRegion;
    private TextureRegion moonTextureRegion;

    @Override
    public Engine onLoadEngine() {
        camera = new Camera(0, 0, width, height);

        EngineOptions engineOptions = new EngineOptions(true, EngineOptions.ScreenOrientation.LANDSCAPE,
                new RatioResolutionPolicy(width, height), camera).setNeedsSound(false).setNeedsMusic(false);
        engineOptions.getTouchOptions().setRunOnUpdateThread(true);
        return new Engine(engineOptions);
    }

    @Override
    public void onLoadResources() {
        this.mBitmapTextureAtlas = new BitmapTextureAtlas(128, 128, TextureOptions.BILINEAR_PREMULTIPLYALPHA);
        BitmapTextureAtlasTextureRegionFactory.setAssetBasePath("gfx/");
        this.ballTextureRegion = BitmapTextureAtlasTextureRegionFactory.createFromAsset(this.mBitmapTextureAtlas, this, "pacman.png", 0, 0);
        this.moonTextureRegion = BitmapTextureAtlasTextureRegionFactory.createFromAsset(this.mBitmapTextureAtlas, this, "moon.png", 0, 0);
        this.mEngine.getTextureManager().loadTexture(this.mBitmapTextureAtlas);
    }

    private Sprite face;

    @Override
    public Scene onLoadScene() {
        mScene = new Scene();

        mScene.setBackground(new ColorBackground(0.5f, 0.5f, 0.5f));
        mScene.setOnSceneTouchListener(this);

        this.mPhysicsWorld = new PhysicsWorld(new Vector2(0, SensorManager.GRAVITY_EARTH),true);

        //final Shape ground = new Rectangle(width / 2.0f, width / 2.0f, height, 2);
        final FixtureDef objectFixtureDef = PhysicsFactory.createFixtureDef(1, 0.5f, 0.5f);

        face = new Sprite(width / 2.0f, height / 2.0f, ballTextureRegion);
        final Sprite button = new Sprite(0, 0, this.moonTextureRegion) {
            @Override
            public boolean onAreaTouched(final TouchEvent pSceneTouchEvent, final float pTouchAreaLocalX, final float pTouchAreaLocalY) {
                Body body;
                if (pSceneTouchEvent.isActionUp())
                {
                    body = PhysicsFactory.createCircleBody(mPhysicsWorld, face, BodyDef.BodyType.DynamicBody, objectFixtureDef);
                    mPhysicsWorld.registerPhysicsConnector(new PhysicsConnector(face, body, true, true));
                    return true;
                }

                return false;
            }
        };

        this.mScene.registerTouchArea(button);

        this.mScene.attachChild(face);
        this.mScene.attachChild(button);
        this.mScene.registerUpdateHandler(this.mPhysicsWorld);

        return this.mScene;
    }

    @Override
    public void onLoadComplete() {
        this.mEngine.stop();
    }

    @Override
    public boolean onSceneTouchEvent(Scene pScene, TouchEvent pSceneTouchEvent) {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }
}
