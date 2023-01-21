package net.givewife.additions.objects.blockentity.netherreactor.particle;

import net.givewife.additions.util.positions.Pos;
import net.givewife.additions.util.positions.VecTrail;
import net.minecraft.util.math.BlockPos;

public class ParticleStages {

    private final BlockPos origin;
    final ParticleStage[] stages;

    public ParticleStages(BlockPos origin, int[] stageLengths) {
        this.origin = origin;
        stages = registerStages(stageLengths);
    }

    public ParticleStage[] registerStages(int[] stageLengths) {
        return new ParticleStage[] {};
    }

    public static abstract class ParticleStage {

        private final int stage, ticks, steps;
        private int progress = 0;
        private VecTrail to;
        //private final Pos step;

        /**
         * Stage: when in the continuity is should start executing
         * Ticks: amount of ticks for this full effect
         * Steps: how much particles are shown
         */
        public ParticleStage(String id, int stage, int ticks, int steps, Pos from, Pos to) {
            this.stage = stage;
            this.ticks = ticks;
            this.steps = steps;
            this.to = new VecTrail(id, from, to, steps);
        }

        public int getStage() {
            return this.stage;
        }

        public Pos next() {
            return this.to.getOffset(this.progress++);
        }

    }

}
