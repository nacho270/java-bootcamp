package com.command;

import com.Domain.Song;

public interface Command {

	public void execute(Song song);
}
