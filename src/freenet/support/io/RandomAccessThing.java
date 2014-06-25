/* This code is part of Freenet. It is distributed under the GNU General
 * Public License, version 2 (or at your option any later version). See
 * http://www.gnu.org/ for further details of the GPL. */
package freenet.support.io;

import java.io.Closeable;
import java.io.IOException;

/**
 * Trivial random access file base interface. Guaranteed to be thread-safe - that is, either the 
 * implementation will serialise reads, or it will support parallel reads natively. The length of
 * the file is constant. Many implementations will provide a nulling constructor - one that takes
 * a size and creates a RandomAccessThing of that length whose content is all 0's.
 * @author toad
 */
public interface RandomAccessThing extends Closeable {

	public long size() throws IOException;
	
	/** Read a block of data from a specific location in the file. Guaranteed to read the whole 
	 * range or to throw, like DataInputStream.readFully(). Must throw if the file is closed.
	 * @param fileOffset The offset within the file to read from.
	 * @param buf The buffer to write to.
	 * @param bufOffset The offset within the buffer to the first read byte.
	 * @param length The length of data to read.
	 * @throws IOException If we were unable to read the required number of bytes etc.
	 */
	public void pread(long fileOffset, byte[] buf, int bufOffset, int length) throws IOException;
	
	public void pwrite(long fileOffset, byte[] buf, int bufOffset, int length) throws IOException;

	@Override
	public void close();
	
	/** Free the underlying resources. May do nothing in some implementations. You should make sure
	 * the object can be GC'ed as well. */
	public void free();
	
}
