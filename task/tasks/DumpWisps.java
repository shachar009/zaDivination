package task.tasks;

import java.util.concurrent.Callable;

import org.powerbot.script.methods.MethodContext;
import org.powerbot.script.util.Condition;
import org.powerbot.script.util.Random;
import org.powerbot.script.wrappers.Component;
import org.powerbot.script.wrappers.GameObject;

import task.Task;
import zaDivination.ZaDivination;




public class DumpWisps extends Task
{
	
	private int tries=0; //failsafe
	public DumpWisps(MethodContext arg0) 
	{
		super(arg0);
		
	}

	@Override
	public boolean activate() 
	{
		return ctx.backpack.select().count() == 28;
	}

	@Override
	public void execute() 
	{
		final Component selectionPanel = ctx.widgets.get(131,26);
		final GameObject rift = ctx.objects.select().id(ZaDivination.riftData.getId()).poll();
		if(!rift.isOnScreen())
		{
			ctx.camera.turnTo(rift.getLocation());
			if(!rift.isOnScreen())
				ctx.movement.stepTowards(rift.getLocation());
		}
		
		if(rift.isOnScreen())
		{
			tries++;
			rift.interact("Convert Memories");
			System.out.println("interacting rift");
			Condition.wait(new Callable <Boolean>()
			{

				@Override
				public Boolean call() throws Exception 
				{
					return selectionPanel.isValid() && selectionPanel.isOnScreen();
				}
					
			},Random.nextInt(300,500),8);
			
			
			if(!(selectionPanel.isValid() && selectionPanel.isOnScreen()))
			{
				if(tries >=3)
				{
					ctx.camera.setAngle(180);
					ctx.movement.stepTowards(rift.getLocation());
					tries =0;
				}
				return;
			}

			
			tries =0;
			selectionPanel.interact("Gain-experience");
			sleep(2000);
			Condition.wait(new Callable <Boolean>()
			{

				@Override
				public Boolean call() throws Exception 
				{
					return ctx.backpack.select().id(ZaDivination.wispData.getItemIds()).count()==0;
				}
					
			},Random.nextInt(300,500),100);
			
		}
		
	}

}
