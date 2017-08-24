package sakura.particle.Factory;

import android.graphics.Bitmap;
import android.graphics.Rect;

import sakura.particle.Particle.Particle;


/**
 * Created by Sakura
 */

public abstract class ParticleFactory {
    public abstract Particle[][] generateParticles(Bitmap bitmap, Rect bound);
}
