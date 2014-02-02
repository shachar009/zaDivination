package zaDivination;


import gui.Gui;
import gui.Painter;

import java.awt.EventQueue;
import java.awt.Graphics;
import java.util.ArrayList;

import org.powerbot.event.PaintListener;
import org.powerbot.script.Manifest;
import org.powerbot.script.PollingScript;
import org.powerbot.script.methods.Skills;

import data.RiftData;
import data.WispData;
import task.Task;
import task.tasks.DumpWisps;
import task.tasks.GatherWisps;

@Manifest (authors={"theasd"} , name = "zaDivination" , description = "Gathers memories and converts them to experience")
public class ZaDivination extends PollingScript implements PaintListener
{
	private ArrayList<Task> taskList = new ArrayList<Task>();
	
	public static WispData wispData;
	public static RiftData riftData;
	public static boolean started = false;
	
	private final Painter painter = new Painter(ctx);
	public static int startingExp;
	public static long startingTime;
	public static int startingLevel;
	@Override
	public void start()
	{	
		EventQueue.invokeLater(new Runnable() 
		{
			public void run() 
			{
					new Gui();
			}
		});
		taskList.add(new GatherWisps(ctx));
		taskList.add(new DumpWisps(ctx));
		
		startingExp = ctx.skills.getExperience(Skills.DIVINATION);
		startingLevel = ctx.skills.getLevel(Skills.DIVINATION);
		

	}
	
	@Override
	public int poll() 
	{
		if(!started)
			return 500;
		
		for(Task task:taskList)
		{
			if(task.activate())
				task.execute();
		}
		return 100;
	}

	@Override
	public void repaint(Graphics g)
	{
		if(!started)
			return;
		painter.draw(g);
	}

}
