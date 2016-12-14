package model;

/**
 * @author: Louis Roebben
 */
interface hitable
{
	boolean getsHit(String place);

	boolean getsHit(Target place);
}
