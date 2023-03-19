package com.springboot.app2.wiki;

/**
 * https://jwt.io
 *
 * Payload data actually exposed and can be encrypted, but token structure is signed by server side by secret word
 * which malicious user don't know.
 * We can even store user db data in token payload section (roles, authorities etc.)
 *
 * Client -> /login (username, pass)             -> Server
 *                                                     |
 *                                                     V
 * Client <- token with encrypted username, role, exp time <- Server
 */
public class JWT {
}
