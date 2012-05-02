/*
 * file:       RowComparator.java
 * author:     Jon Iles
 * copyright:  (c) Packwood Software 2012
 * date:       29/04/2012
 */

/*
 * This library is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as published by the
 * Free Software Foundation; either version 2.1 of the License, or (at your
 * option) any later version.
 *
 * This library is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY
 * or FITNESS FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public
 * License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this library; if not, write to the Free Software Foundation, Inc.,
 * 59 Temple Place, Suite 330, Boston, MA 02111-1307, USA.
 */

package net.sf.mpxj.asta;

import java.util.Comparator;

/**
 * Simple comparator to allow two rows to be compared
 * by integer column values.
 */
class RowComparator implements Comparator<Row>
{
   /**
    * Constructor.
    * 
    * @param sortColumns columns used in the comparison.
    */
   public RowComparator(String... sortColumns)
   {
      m_sortColumns = sortColumns;
   }

   /**
    * {@inheritDoc}
    */
   @Override public int compare(Row leftRow, Row rightRow)
   {
      int result = 0;
      int index = 0;
      while (index < m_sortColumns.length)
      {
         Integer leftValue = leftRow.getInteger(m_sortColumns[index]);
         Integer rightValue = rightRow.getInteger(m_sortColumns[index]);
         result = leftValue.compareTo(rightValue);
         if (result != 0)
         {
            break;
         }
         ++index;
      }

      return result;
   }

   private String[] m_sortColumns;
}
