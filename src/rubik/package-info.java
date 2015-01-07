/**
 * This package dedicated to the Rubik's cube.
 * We'll represent the rubik's cube as an array of six faces (the faces of the
 * cube) and represent the colors as numbers from 0 to 5 (six colors)
 * The six faces will be represented as an array of facets from 0 to 8, like this.
 * <code>
 *             +-----------+
 *          [0]| 0 0 0 0 0 |
 *             | 0 0 0 0 0 |
 *             | 0 0 0 0 0 |
 *             | 0 0 0 0 0 |
 * [1]         | 0 0 0 0 0 | [3]         [4]
 * +-----------+-----------+-----------+-----------+
 * | 1 1 1 1 1 | 2 2 2 2 2 | 3 3 3 3 3 | 4 4 4 4 4 |
 * | 1 1 1 1 1 | 2 2 2 2 2 | 3 3 3 3 3 | 4 4 4 4 4 |
 * | 1 1 1 1 1 | 2 2 2 2 2 | 3 3 3 3 3 | 4 4 4 4 4 |
 * | 1 1 1 1 1 | 2 2 2 2 2 | 3 3 3 3 3 | 4 4 4 4 4 |
 * | 1 1 1 1 1 | 2 2 2 2 2 | 3 3 3 3 3 | 4 4 4 4 4 |
 * +-----------+-----------+-----------+-----------+
 *                    [5]  | 5 5 5 5 5 |
 *                         | 5 5 5 5 5 |
 *                         | 5 5 5 5 5 |
 *                         | 5 5 5 5 5 |
 *                         | 5 5 5 5 5 |
 *                         +-----------+
 * </code>
 * The cells allow for different characters to allow to express different colors for
 * each cell, being the colors mapped also to the faces for the movements.
 * The movements are expressed as a face and a depth, so we can cope with different
 * cube sizes.  The Face marks the center of the face being used as the axis for a
 * 90º rotation (counterclockwise) so a 180º appears as two 90º rotations and a 270º
 * as a 90º on the opposite face.
 * 
 * To make a rotation, first we select if the rotation is for the first slice or the
 * last, in that case, we rotate complete vectors, as they are disposed horizontally
 * in the lateral faces.  In case we must do the first or the last slice, we also
 * need to rotate local faces, so we need to construct a list of the rotations we must
 * do, and we will be able to rotate them quickly.
 */
/**
 * @author eluscoo
 *
 */
package rubik;