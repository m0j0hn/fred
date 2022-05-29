package freenet.node;

/**
 * Something that wants to listen for nodeToNodeMessage's.
 * @author <a href="mailto:toad@amphibian.dyndns.org">Matthew Toseland (0xE43DA450)</a>
 */
public interface NodeToNodeMessageListener {
	
	public void handleMessage(byte[] data, boolean fromDarknet, PeerNode source, int type);

}
