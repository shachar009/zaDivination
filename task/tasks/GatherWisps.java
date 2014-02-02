package task.tasks;

import org.powerbot.script.methods.MethodContext;
import org.powerbot.script.wrappers.Npc;


import task.Task;
import zaDivination.ZaDivination;



public class GatherWisps extends Task
{
	private int tries =0;
	public GatherWisps(MethodContext arg0)
	{
		super(arg0);

	}

	@Override
	public boolean activate() 
	{
		if(ctx.players.local().getAnimation() ==-1 && !ctx.players.local().isInMotion()&& ctx.backpack.select().count()<28)
				return true;
		return false;
	}

	@Override
	public void execute() 
	{

		final Npc wisp = ctx.npcs.select().id(ZaDivination.wispData.getId()).nearest().poll();
		
		if(!wisp.isOnScreen())
		{
			ctx.camera.turnTo(wisp.getLocation());
			if(!wisp.isOnScreen())
				ctx.movement.stepTowards(wisp.getLocation());
		}
		
		if(wisp.isOnScreen())
		{
			wisp.interact("Harvest");
			sleep(2000);
		}

		
		
	}

}
