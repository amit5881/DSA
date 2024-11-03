package Karat;

/*
You work in an automated robot factory. Once robots are assembled, they are sent to the shipping center via a series of autonomous delivery carts, each of which moves packages on a one-way route.

Given input that provides the (directed) steps that each cart takes as pairs, write a function that identifies all the start locations, and a collection of all of the possible ending locations for each start location.

In this diagram, starting locations are at the top and destinations are at the bottom - i.e. the graph is directed exclusively downward.

   A          E      J       Key:  [Origins]
  / \        / \      \                 \
 B   C      F   L      M             [Destinations]
  \ /  \   /
   K     G
        / \
       H   I

paths = [
  ["B", "K"],
  ["C", "K"],
  ["E", "L"],
  ["F", "G"],
  ["J", "M"],
  ["E", "F"],
  ["C", "G"],
  ["A", "B"],
  ["A", "C"],
  ["G", "H"],
  ["G", "I"]
]

Expected output (unordered):
[
  "A": ["K", "H", "I"],
  "E": ["H", "L", "I"],
  "J": ["M"]
]

N: Number of pairs in the input.
*/

public class GraphQuestion {
}
